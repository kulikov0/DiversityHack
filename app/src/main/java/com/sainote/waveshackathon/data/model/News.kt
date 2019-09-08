package com.sainote.waveshackathon.data.model

import java.io.Serializable

data class News(val title: String,
                val author: String,
                val text: String,
                val image: String,
                val authorPhoto: String,
                val fromNewsScreen: Boolean): Serializable