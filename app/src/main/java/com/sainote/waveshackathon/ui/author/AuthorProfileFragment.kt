package com.sainote.waveshackathon.ui.author

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentAuthorProfileBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import javax.inject.Inject

class AuthorProfileFragment : BaseFragment(R.layout.fragment_author_profile) {

    @Inject
    lateinit var viewModel: AuthorProfileViewModel

    val news by lazy { AuthorProfileFragmentArgs.fromBundle(arguments!!).news }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentAuthorProfileBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@AuthorProfileFragment
        }
    }

}