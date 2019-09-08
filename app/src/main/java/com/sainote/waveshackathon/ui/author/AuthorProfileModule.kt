package com.sainote.waveshackathon.ui.author

import com.sainote.waveshackathon.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class AuthorProfileModule {

    @Module
    companion object {


        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: AuthorProfileViewModelImpl): AuthorProfileViewModel = impl

    }


    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope


}