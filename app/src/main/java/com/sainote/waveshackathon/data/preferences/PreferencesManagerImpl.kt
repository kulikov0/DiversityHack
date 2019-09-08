package com.sainote.waveshackathon.data.preferences

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.sainote.waveshackathon.di.qualifier.PreferencesInfo
import javax.inject.Inject

class PreferencesManagerImpl @Inject constructor(context: Context,
                                                 @PreferencesInfo private val prefName: String):
    PreferencesManager {

    private val prefs: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    override fun putBoolean(name: String, value: Boolean?) {
        if (value != null) {
            val editor = prefs.edit()
            editor.putBoolean(name, value)
            editor.apply()
        }
        else
            remove(name)
    }

    override fun getBoolean(name: String): Boolean?   =
        if (prefs.contains(name)) prefs.getBoolean(name, false) else null

    override fun <T> getSerializable(name: String, clz: Class<T>): T? {
        return prefs.getString(name, null)?.let { Gson().fromJson(it, clz) }
    }

    override fun <T> putSerializable(name: String, value: T?) {
        if (value != null) {
            val editor = prefs.edit()
            editor.putString(name, Gson().toJson(value))
            editor.apply()
        }
        else
            remove(name)
    }

    @SuppressLint("CommitPrefEdits")
    override fun remove(name: String) {
        if (prefs.contains(name)) {
            val editor = prefs.edit()
            editor.remove(name)
            editor.apply()
        }
    }

    @SuppressLint("CommitPrefEdits")
    override fun putString(name: String, value: String?) {
        if (value != null) {
            val editor = prefs.edit()
            editor.putString(name, value)
            editor.apply()
        }
        else
            remove(name)
    }

    override fun getString(name: String): String?  =
        prefs.getString(name, null)
}