package com.sainote.waveshackathon.ui.profile

import androidx.lifecycle.ViewModelProviders
import com.sainote.waveshackathon.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class ProfileModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModelData(fragment: ProfileFragment): ProfileViewModelImpl.Model =
            ViewModelProviders.of(fragment)[ProfileViewModelImpl.Model::class.java]

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: ProfileViewModelImpl): ProfileVIewModel = impl

    }


    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope


}