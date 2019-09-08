package com.sainote.waveshackathon.ui.onboarding

import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sainote.waveshackathon.databinding.ActivityOnboardingBinding
import com.sainote.waveshackathon.di.module.FragmentInjectorModule
import com.sainote.waveshackathon.di.scope.AppActivityScope
import com.sainote.waveshackathon.di.scope.FragmentScope
import dagger.Module
import dagger.Provides
import com.sainote.waveshackathon.ui.base.activity.BaseActivityModule
import com.sainote.waveshackathon.ui.onboarding.articles.ExploreArticlesFragment
import com.sainote.waveshackathon.ui.onboarding.courses.TakeCoursesFragment
import com.sainote.waveshackathon.ui.onboarding.start.StartExploringFragment
import dagger.android.ContributesAndroidInjector

@Module(includes = [BaseActivityModule::class, FragmentInjectorModule::class])
abstract class OnboardingActivityModule {

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun articlesFragmentInjector(): ExploreArticlesFragment

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun coursesFragmentInjector(): TakeCoursesFragment

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun startFragmentInjector(): StartExploringFragment

    @Module
    companion object {

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBaseActivity(activity: OnboardingActivity): BaseActivity = activity

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModelData(activity: OnboardingActivity): OnboardingViewModelImpl.Model =
            ViewModelProviders.of(activity)[OnboardingViewModelImpl.Model::class.java]


        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideViewModel(impl: OnboardingViewModelImpl): OnboardingViewModel = impl

        @Provides
        @JvmStatic
        @AppActivityScope
        fun provideBinding(activity: OnboardingActivity,
                           viewmodel: OnboardingViewModel
        ):
                ActivityOnboardingBinding =
            DataBindingUtil.bind<ActivityOnboardingBinding>(activity.root)!!.apply {
                this.viewmodel = viewmodel
                this.lifecycleOwner = activity
            }

        @Provides
        @JvmStatic
        fun provideArticlesFragment() = ExploreArticlesFragment()

        @Provides
        @JvmStatic
        fun provideCoursesFragment() = TakeCoursesFragment()

        @Provides
        @JvmStatic
        fun provideStartFragment() = StartExploringFragment()

    }

}