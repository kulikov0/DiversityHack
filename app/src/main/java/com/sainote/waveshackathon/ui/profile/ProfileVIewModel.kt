package com.sainote.waveshackathon.ui.profile

import androidx.lifecycle.LiveData

interface ProfileVIewModel {

    val userPhoto: LiveData<String>
    val name: LiveData<String>
    val seed: LiveData<String>
    val balance: LiveData<String>
    val executing: LiveData<Boolean>

    fun onLogoutClicked()
}