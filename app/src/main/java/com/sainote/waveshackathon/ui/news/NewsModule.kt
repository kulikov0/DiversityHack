package com.sainote.waveshackathon.ui.news

import android.content.Context
import android.location.LocationManager
import androidx.lifecycle.ViewModelProviders
import com.sainote.waveshackathon.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class NewsModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModelData(fragment: NewsFragment): NewsViewModelImpl.Model =
            ViewModelProviders.of(fragment)[NewsViewModelImpl.Model::class.java]

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: NewsViewModelImpl): NewsViewModel = impl

    }


    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope


}