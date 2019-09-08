package com.sainote.waveshackathon.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface QuestionViewModel {

    val category: MutableLiveData<String>
    val question: MutableLiveData<String>
    val executing: LiveData<Boolean>
    val amount: MutableLiveData<String>
    fun onCategoryClicked()
    fun onSendClick()
    fun onAmountClick()

}