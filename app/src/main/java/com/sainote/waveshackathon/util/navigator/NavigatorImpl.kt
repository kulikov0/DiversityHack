package com.sainote.waveshackathon.util.navigator

import com.sainote.waveshackathon.ui.main.MainActivity
import com.sainote.waveshackathon.ui.onboarding.OnboardingActivity
import android.content.Intent
import android.widget.Toast
import com.sainote.waveshackathon.util.session.SessionManager
import com.sainote.waveshackathon.util.ui.UIUtils
import com.sainote.waveshackathon.ui.base.activity.BaseActivity
import com.sainote.waveshackathon.ui.login.LoginActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor(var activity: BaseActivity,
                                        var uiUtils: UIUtils,
                                        private val sessionManager: SessionManager
) : Navigator {


    override fun showNoImplemented() = Toast.makeText(activity, "Not implemented", Toast.LENGTH_SHORT).show()

    override fun makeToast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()

    override fun closeScreen() = activity.supportFinishAfterTransition()

    override fun openMainScreen() = activity.startActivity(Intent(activity, MainActivity::class.java).apply {
        flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK))
    })

    override fun openAuthScreen() = activity.startActivity(Intent(activity, LoginActivity::class.java).apply {
        flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK))
    })

    override fun openOnboardingScreen() = activity.startActivity(Intent(activity, OnboardingActivity::class.java).apply {
        flags = (Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK))
    })

}