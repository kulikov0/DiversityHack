package com.sainote.waveshackathon.util.session

import com.sainote.waveshackathon.data.model.User

interface SessionManager {
    //fun authenticate(loginResult: LoginResult)
    fun logout()
    fun checkAuthenticated()

    var token: String?
    val authenticated: Boolean
    var user: User?

    var onboardingCompleted: Boolean
}