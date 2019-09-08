package com.sainote.waveshackathon.util.navigator

interface Navigator {

    fun showNoImplemented()
    fun closeScreen()
    fun makeToast(message: String)
    fun openMainScreen()
    fun openOnboardingScreen()
    fun openAuthScreen()

}