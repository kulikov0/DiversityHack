package com.sainote.waveshackathon.ui.onboarding.articles

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentExploreArticlesBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import com.sainote.waveshackathon.ui.onboarding.OnboardingViewModel
import javax.inject.Inject

class ExploreArticlesFragment : BaseFragment(R.layout.fragment_explore_articles) {

    @Inject
    lateinit var viewModel: OnboardingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentExploreArticlesBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@ExploreArticlesFragment
        }
    }

}