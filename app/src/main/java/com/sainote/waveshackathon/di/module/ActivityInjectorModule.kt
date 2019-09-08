package com.sainote.waveshackathon.di.module

import com.sainote.waveshackathon.ui.onboarding.OnboardingActivity
import com.sainote.waveshackathon.ui.onboarding.OnboardingActivityModule
import com.sainote.waveshackathon.ui.splash.SplashActivity
import com.sainote.waveshackathon.ui.splash.SplashModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.sainote.waveshackathon.di.scope.AppActivityScope
import com.sainote.waveshackathon.ui.login.LoginActivity
import com.sainote.waveshackathon.ui.login.LoginModule
import com.sainote.waveshackathon.ui.main.MainActivity
import com.sainote.waveshackathon.ui.main.MainModule

@Module
abstract class ActivityInjectorModule {

    @AppActivityScope
    @ContributesAndroidInjector(modules = [SplashModule::class])
    internal abstract fun contributeSplashActivity() : SplashActivity

    @AppActivityScope
    @ContributesAndroidInjector(modules = [OnboardingActivityModule::class])
    internal abstract fun contributeOnboardingActivity(): OnboardingActivity

    @AppActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    internal abstract fun contributeLoginActivty(): LoginActivity

    @AppActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

}