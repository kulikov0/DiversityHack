package com.sainote.waveshackathon.di.component

import android.app.Application
import com.sainote.waveshackathon.App
import com.sainote.waveshackathon.di.module.ActivityInjectorModule
import com.sainote.waveshackathon.di.module.ApplicationModule
import com.sainote.waveshackathon.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    ActivityInjectorModule::class,
    AndroidSupportInjectionModule::class,
    NetworkModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}