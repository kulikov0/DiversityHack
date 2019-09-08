package com.sainote.waveshackathon

import android.app.Activity
import android.os.StrictMode
import androidx.multidex.MultiDexApplication
import com.sainote.waveshackathon.di.component.DaggerAppComponent
import com.wavesplatform.sdk.WavesSdk
import com.wavesplatform.sdk.utils.Environment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App: MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().build())
        WavesSdk.init(this, Environment.TEST_NET)
        WavesSdk.keeper().configureDApp(
            this,
            "RHDV",
            "https://avatars2.githubusercontent.com/u/18295288")
        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

}