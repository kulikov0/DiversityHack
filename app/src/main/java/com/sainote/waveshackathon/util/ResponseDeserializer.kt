package com.sainote.waveshackathon.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class ResponseDeserializer {

    fun get(): Gson = GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()

}