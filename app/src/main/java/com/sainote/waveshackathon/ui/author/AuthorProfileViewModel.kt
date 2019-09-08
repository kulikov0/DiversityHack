package com.sainote.waveshackathon.ui.author

import androidx.lifecycle.LiveData
import com.sainote.waveshackathon.data.model.News

interface AuthorProfileViewModel {

    val news: News
    val executing: LiveData<Boolean>

    fun onDonateClicked()

}