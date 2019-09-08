package com.sainote.waveshackathon.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LoginViewModel {

    fun onLoginClicked()

    val buttonEnabled: LiveData<Boolean>
    val login: MutableLiveData<String>
    val executing: LiveData<Boolean>

}