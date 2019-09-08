package com.sainote.waveshackathon.ui.splash

import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import com.sainote.waveshackathon.util.session.SessionManager
import android.os.Handler
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.ActivitySplashBinding
import com.sainote.waveshackathon.util.navigator.Navigator
import dagger.Lazy
import javax.inject.Inject

class SplashActivity : BaseActivity(R.layout.activity_splash) {

    @Inject
    lateinit var sessionManager: SessionManager

    @Inject
    lateinit var navigator: Navigator

    @Inject
    override
    lateinit var binding: Lazy<ActivitySplashBinding>

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            /*
            when {
                !sessionManager.onboardingCompleted -> navigator.openOnboardingScreen()
                !sessionManager.authenticated -> navigator.openAuthScreen()
                else -> navigator.openMainScreen()
            }*/
            navigator.openOnboardingScreen()
        }, 1000)
    }

}