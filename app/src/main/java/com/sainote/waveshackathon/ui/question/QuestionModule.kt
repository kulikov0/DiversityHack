package com.sainote.waveshackathon.ui.question

import androidx.lifecycle.ViewModelProviders
import com.sainote.waveshackathon.ui.base.fragment.BaseFragmentModule
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module(includes = [BaseFragmentModule::class])
abstract class QuestionModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModelData(fragment: QuestionFragment): QuestionViewModelImpl.Model =
            ViewModelProviders.of(fragment)[QuestionViewModelImpl.Model::class.java]

        @Provides
        @JvmStatic
        @ModuleScope
        fun provideViewModel(impl: QuestionViewModelImpl): QuestionViewModel = impl

    }


    @Scope
    @kotlin.annotation.MustBeDocumented
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    annotation class ModuleScope


}