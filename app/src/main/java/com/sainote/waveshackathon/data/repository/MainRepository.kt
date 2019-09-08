package com.sainote.waveshackathon.data.repository

import com.sainote.waveshackathon.data.network.Api
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: Api
)