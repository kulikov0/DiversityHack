package com.sainote.waveshackathon.data.preferences

interface PreferencesManager {

    fun remove(name: String)

    fun putString(name: String, value: String?)
    fun getString(name: String): String?

    fun <T> getSerializable(name: String, clz: Class<T>): T?
    fun <T> putSerializable(name: String, value: T?)

    fun putBoolean(name: String, value: Boolean?)
    fun getBoolean(name: String): Boolean?

}