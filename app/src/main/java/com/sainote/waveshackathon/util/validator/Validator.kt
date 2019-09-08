package com.sainote.waveshackathon.util.validator

import android.view.View
import androidx.lifecycle.MutableLiveData

interface Validator {

    val showErrors: MutableLiveData<Boolean>
    val hasErrors: MutableLiveData<Boolean>
    fun setValidationState(view: View, index: Int, error: Boolean, message: String)
    fun validate(): Boolean
    fun validateView(view: View)

}