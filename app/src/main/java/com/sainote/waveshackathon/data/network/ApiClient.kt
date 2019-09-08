package com.sainote.waveshackathon.data.network

import retrofit2.Retrofit

class ApiClient(retrofit: Retrofit): Api {

    interface Service {

    }

    private val service = retrofit.create(Service::class.java)

}