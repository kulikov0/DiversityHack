package com.sainote.waveshackathon.util.session

import com.sainote.waveshackathon.data.model.User
import com.sainote.waveshackathon.data.preferences.PreferencesManager
import java.lang.RuntimeException

class SessionManagerImpl (val preferences: PreferencesManager) : SessionManager {

    override fun checkAuthenticated() {
        if (!authenticated)
            throw RuntimeException("User not logged in")

    }

    override fun logout() {
        token = null
        user = null
    }

    /*override fun authenticate(loginResult: LoginResult) {
        token = loginResult.token
        user = loginResult.user
    }*/

    override var token: String? = null
        get() = preferences.getString(P_TOKEN)
        set(value) {
            preferences.putString(P_TOKEN, value)
            field = value
        }

    override var onboardingCompleted: Boolean
        get() = preferences.getBoolean(P_ONBOARDING_COMPLETE) == true
        set(value) { preferences.putBoolean(P_ONBOARDING_COMPLETE, value) }

    override val authenticated: Boolean get() = !token.isNullOrEmpty()

    override var user: User? = null
        get() = preferences.getSerializable(P_USER, User::class.java)
        set(value) {
            preferences.putSerializable(P_USER, value)
            field = value
        }

    companion object {
        const val P_TOKEN = "auth_token"
        const val P_USER = "auth_user"
        const val P_ONBOARDING_COMPLETE = "onboarding_complete"
    }
}
