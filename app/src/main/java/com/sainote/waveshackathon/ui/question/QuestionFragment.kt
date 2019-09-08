package com.sainote.waveshackathon.ui.question

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.sainote.waveshackathon.R
import com.sainote.waveshackathon.databinding.FragmentQuestionBinding
import com.sainote.waveshackathon.ui.base.fragment.BaseFragment
import javax.inject.Inject

class QuestionFragment : BaseFragment(R.layout.fragment_question) {

    @Inject
    lateinit var viewModel: QuestionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentQuestionBinding>(view)!!.apply {
            viewmodel = viewModel
            lifecycleOwner = this@QuestionFragment
        }
    }

}