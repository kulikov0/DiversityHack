package com.sainote.waveshackathon.ui.main

import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.databinding.ActivityMainBinding
import com.sainote.waveshackathon.di.module.FragmentInjectorModule
import com.sainote.waveshackathon.di.scope.AppActivityScope
import com.sainote.waveshackathon.ui.author.AuthorProfileFragment
import com.sainote.waveshackathon.ui.author.AuthorProfileModule
import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import com.sainote.waveshackathon.ui.base.activity.BaseActivityModule
import com.sainote.waveshackathon.ui.categories.CategoriesFragment
import com.sainote.waveshackathon.ui.categories.CategoriesModule
import com.sainote.waveshackathon.ui.news.NewsFragment
import com.sainote.waveshackathon.ui.news.NewsModule
import com.sainote.waveshackathon.ui.profile.ProfileFragment
import com.sainote.waveshackathon.ui.profile.ProfileModule
import com.sainote.waveshackathon.ui.question.QuestionFragment
import com.sainote.waveshackathon.ui.question.QuestionModule
import com.sainote.waveshackathon.util.validator.Validator
import com.sainote.waveshackathon.util.validator.ValidatorImpl
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class, FragmentInjectorModule::class])
abstract class MainModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBaseActivity(activity: MainActivity): BaseActivity = activity

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModel(impl: MainViewModelImpl): MainViewModel = impl

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBinding(
            activity: MainActivity,
            viewModel: MainViewModel
        ): ActivityMainBinding =
            DataBindingUtil.bind<ActivityMainBinding>(activity.root)!!.apply {
                this.viewmodel = viewModel
                this.lifecycleOwner = activity
            }

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideValidator(binding: ActivityMainBinding): Validator = ValidatorImpl(binding)

    }


    @NewsModule.ModuleScope
    @ContributesAndroidInjector(modules = [NewsModule::class])
    abstract fun contributeNewsModule(): NewsFragment

    @CategoriesModule.ModuleScope
    @ContributesAndroidInjector(modules = [CategoriesModule::class])
    abstract fun contributeCategoriesModule(): CategoriesFragment

    @QuestionModule.ModuleScope
    @ContributesAndroidInjector(modules = [QuestionModule::class])
    abstract fun contributeQuestionModule(): QuestionFragment

    @ProfileModule.ModuleScope
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun contributeProfileModule(): ProfileFragment

    @AuthorProfileModule.ModuleScope
    @ContributesAndroidInjector(modules = [AuthorProfileModule::class])
    abstract fun contributeAuthorProfileModule(): AuthorProfileFragment

}