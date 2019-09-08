package com.sainote.waveshackathon.ui.splash

import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.databinding.ActivitySplashBinding
import com.sainote.waveshackathon.di.module.FragmentInjectorModule
import com.sainote.waveshackathon.di.scope.AppActivityScope
import dagger.Module
import dagger.Provides
import com.sainote.waveshackathon.ui.base.activity.BaseActivityModule

@Module(includes = [BaseActivityModule::class, FragmentInjectorModule::class])
abstract class SplashModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBaseActivity(activity: SplashActivity): BaseActivity = activity

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModel(impl: SplashViewModelImpl): SplashViewModel = impl

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBinding(activity: SplashActivity,
                           viewModel: SplashViewModel
        ): ActivitySplashBinding =
            DataBindingUtil.bind<ActivitySplashBinding>(activity.root)!!.apply {
                this.viewmodel =  viewModel
                this.lifecycleOwner = activity
            }

    }

}