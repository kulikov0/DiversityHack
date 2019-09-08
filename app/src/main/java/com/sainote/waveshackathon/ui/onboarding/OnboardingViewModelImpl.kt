package com.sainote.waveshackathon.ui.onboarding

import com.sainote.waveshackathon.util.session.SessionManager
import com.sainote.waveshackathon.util.ui.UIUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sainote.waveshackathon.util.navigator.Navigator
import javax.inject.Inject

class OnboardingViewModelImpl @Inject constructor(
    val model: Model,
    val navigator: Navigator,
    val ui: UIUtils,
    val activity: OnboardingActivity,
    val sessionManager: SessionManager
): OnboardingViewModel {


    override var pageCount = 0
    override val pageIndex = model.pageIndex

    override fun onBackClick() {
        activity.onBackPressed()
    }

    override fun onCompleteClick() = navigator.openAuthScreen()

    override fun onNextClick() {
        if (pageIndex.value ?: 0 < pageCount)
            pageIndex.value = (pageIndex.value ?: 0) + 1
    }

    class Model: ViewModel() {
        val pageIndex = MutableLiveData<Int>().apply { value = 0 }
    }

}