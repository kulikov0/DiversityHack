package com.sainote.waveshackathon.ui.login

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sainote.waveshackathon.databinding.ActivityLoginBinding
import com.sainote.waveshackathon.di.module.FragmentInjectorModule
import com.sainote.waveshackathon.di.scope.AppActivityScope
import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import com.sainote.waveshackathon.ui.base.activity.BaseActivityModule
import dagger.Module
import dagger.Provides

@Module(includes = [BaseActivityModule::class, FragmentInjectorModule::class])
abstract class LoginModule  {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBaseActivity(activity: LoginActivity): BaseActivity = activity

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModelData(activity: LoginActivity): LoginViewModelImpl.Model =
            ViewModelProviders.of(activity) [LoginViewModelImpl.Model::class.java]

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModel(impl: LoginViewModelImpl): LoginViewModel = impl

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBinding(activity: LoginActivity,
                           viewModel: LoginViewModel
        ): ActivityLoginBinding =
            DataBindingUtil.bind<ActivityLoginBinding>(activity.root)!!.apply {
                this.viewmodel =  viewModel
                this.lifecycleOwner = activity
            }

    }

}