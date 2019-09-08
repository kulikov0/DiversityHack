package com.sainote.waveshackathon.ui.onboarding.start

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentStartExploringBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import com.sainote.waveshackathon.ui.onboarding.OnboardingViewModel
import javax.inject.Inject

class StartExploringFragment : BaseFragment(R.layout.fragment_start_exploring) {

    @Inject
    lateinit var viewModel: OnboardingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentStartExploringBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@StartExploringFragment
        }
    }

}