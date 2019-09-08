package com.sainote.waveshackathon.ui.onboarding.courses

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentTakeCoursesBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import com.sainote.waveshackathon.ui.onboarding.OnboardingViewModel
import javax.inject.Inject

class TakeCoursesFragment : BaseFragment(R.layout.fragment_take_courses) {

    @Inject
    lateinit var viewModel: OnboardingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentTakeCoursesBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@TakeCoursesFragment
        }
    }

}