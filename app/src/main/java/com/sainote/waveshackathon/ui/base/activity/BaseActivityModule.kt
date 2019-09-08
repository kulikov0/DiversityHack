package com.sainote.waveshackathon.ui.base.activity

import com.sainote.waveshackathon.util.permissions.PermissionManager
import com.sainote.waveshackathon.util.permissions.PermissionManagerImpl
import com.sainote.waveshackathon.util.ui.UIUtils
import com.sainote.waveshackathon.util.ui.UIUtilsImpl
import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.sainote.waveshackathon.di.scope.AppActivityScope
import com.sainote.waveshackathon.util.navigator.Navigator
import com.sainote.waveshackathon.util.navigator.NavigatorImpl
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule {


    @Provides
    @AppActivityScope
    internal fun provideContext(activity: BaseActivity): Context = activity

    @Provides
    @AppActivityScope
    internal fun provideView(activity: BaseActivity): View = activity.root

    @Provides
    @AppActivityScope
    internal fun provideNavigator(navigator: NavigatorImpl): Navigator = navigator

    @Provides
    @AppActivityScope
    internal fun providePermissionManager(impl: PermissionManagerImpl): PermissionManager = impl

    @Provides
    @AppActivityScope
    internal fun provideUIUtils(impl: UIUtilsImpl): UIUtils = impl

    @Provides
    @AppActivityScope
    internal fun provideFragmentManager(activity: BaseActivity): FragmentManager = activity.supportFragmentManager

    @Provides
    @AppActivityScope
    internal fun provideLifecycle(activity: BaseActivity): Lifecycle = activity.lifecycle

    @Provides
    @AppActivityScope
    internal fun provideLifecycleOwner(activity: BaseActivity): LifecycleOwner = activity

}