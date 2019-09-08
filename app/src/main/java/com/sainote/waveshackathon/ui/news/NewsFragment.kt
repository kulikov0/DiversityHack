package com.sainote.waveshackathon.ui.news

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.data.model.News
import com.sainote.waveshackathon.databinding.FragmentNewsBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import javax.inject.Inject

class NewsFragment : BaseFragment(R.layout.fragment_news) {

    @Inject
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentNewsBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@NewsFragment
        }
    }

    fun openAuthorScreen(news: News) {
        findNavController().navigate(NewsFragmentDirections.actionNewsToAuthorProfile(news))
    }

}