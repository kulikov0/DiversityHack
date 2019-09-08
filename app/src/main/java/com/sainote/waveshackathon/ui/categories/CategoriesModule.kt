package com.sainote.waveshackathon.ui.categories

import androidx.lifecycle.ViewModelProviders
import com.sainote.waveshackathon.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class CategoriesModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModelData(fragment: CategoriesFragment): CategoriesViewModelImpl.Model =
            ViewModelProviders.of(fragment)[CategoriesViewModelImpl.Model::class.java]

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: CategoriesViewModelImpl): CategoriesViewModel = impl

    }


    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope


}