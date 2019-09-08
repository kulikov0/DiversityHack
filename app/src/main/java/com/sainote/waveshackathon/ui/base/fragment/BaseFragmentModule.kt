package com.sainote.waveshackathon.ui.base.fragment

import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.sainote.waveshackathon.di.qualifier.FragmentContext
import dagger.Module
import dagger.Provides

@Module
class BaseFragmentModule {

    @Provides
    @FragmentContext
    internal fun provideFragmentManager(fragment: BaseFragment): FragmentManager = fragment.childFragmentManager

    @Provides
    @FragmentContext
    internal fun provideLifecycle(fragment: BaseFragment): Lifecycle = fragment.lifecycle

}