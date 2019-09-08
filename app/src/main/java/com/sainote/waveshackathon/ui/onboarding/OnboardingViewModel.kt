package com.sainote.waveshackathon.ui.onboarding

import androidx.lifecycle.MutableLiveData

interface OnboardingViewModel {

    val pageIndex: MutableLiveData<Int>
    var pageCount: Int
    fun onBackClick()
    fun onNextClick()
    fun onCompleteClick()

}