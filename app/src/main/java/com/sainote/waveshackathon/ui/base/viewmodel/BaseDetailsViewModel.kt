package com.sainote.waveshackathon.ui.base.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

open class BaseDetailsViewModel<T> : BaseViewModel() {
    val data = MutableLiveData<T>()
    val id = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>().apply { value = true }
    val loadRequired get() = data.value == null && id.value != null
    val isempty get() = data.value == null

    open fun bindToLifecycle(activity: LifecycleOwner) {
        data.observe(activity, Observer { notifyChange() })
    }
}