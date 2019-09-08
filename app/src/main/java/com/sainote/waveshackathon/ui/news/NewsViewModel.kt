package com.sainote.waveshackathon.ui.news

import android.location.Location
import androidx.lifecycle.LiveData
import com.sainote.waveshackathon.data.model.News

interface NewsViewModel {

    val news: LiveData<List<News>>
    val loading: LiveData<Boolean>
    fun refresh()

}