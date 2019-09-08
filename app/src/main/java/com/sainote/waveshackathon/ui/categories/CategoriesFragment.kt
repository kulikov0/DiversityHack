package com.sainote.waveshackathon.ui.categories

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentCategoriesBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import javax.inject.Inject

class CategoriesFragment : BaseFragment(R.layout.fragment_categories) {

    @Inject
    lateinit var viewModel: CategoriesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentCategoriesBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@CategoriesFragment
        }
    }

}