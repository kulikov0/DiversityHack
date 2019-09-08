package com.sainote.waveshackathon.di.module

import android.app.Application
import android.content.Context
import com.sainote.waveshackathon.BuildConfig
import com.sainote.waveshackathon.data.preferences.PreferencesManager
import com.sainote.waveshackathon.data.preferences.PreferencesManagerImpl
import com.sainote.waveshackathon.di.qualifier.PreferencesInfo
import com.sainote.waveshackathon.util.session.SessionManager
import com.sainote.waveshackathon.util.session.SessionManagerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
open class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application

    @Provides
    @PreferencesInfo
    fun providePrefFileName(): String = BuildConfig.PREF_NAME

    @Provides
    @Singleton
    fun providePrefHelper(preferences: PreferencesManagerImpl): PreferencesManager = preferences

    @Provides
    @Singleton
    open fun provideSessionManager(preferences: PreferencesManager): SessionManager {
        return SessionManagerImpl(preferences)
    }
}