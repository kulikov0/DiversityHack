package com.sainote.waveshackathon.ui.profile

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentProfileBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import javax.inject.Inject

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    @Inject
    lateinit var viewModel: ProfileVIewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentProfileBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@ProfileFragment
        }
    }

}