package com.sainote.waveshackathon.ui.base.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

open class BaseListViewModel<T> : BaseViewModel() {
    val data = MutableLiveData<List<T>>()
    val loading = MutableLiveData<Boolean>().apply { value = true }
    val hasmore = MutableLiveData<Boolean>().apply { value = false }
    open val loadRequired get() = data.value == null
    var nextPageUrl: String? = null


    fun append(result: List<T>) {
        if (data.value == null)
            data.value = result
        else
            data.value = data.value!!.plus(result)
        nextPageUrl = null
        hasmore.value = false
    }


    fun append(result: List<T>, nextPageUrl: String?) {
        if (data.value == null)
            data.value = result
        else
            data.value = data.value!!.plus(result)
        this.nextPageUrl = nextPageUrl
        hasmore.value = !nextPageUrl.isNullOrEmpty()
    }

    fun clear() {
        data.value = null
        nextPageUrl = null
    }

    fun bindToLifecycle(activity: LifecycleOwner) {
        data.observe(activity, Observer { notifyChange() })
        loading.observe(activity, Observer { notifyChange() })
        hasmore.observe(activity, Observer { notifyChange() })
    }

    fun insertAtTop(result: List<T>) {
        if (data.value == null)
            data.value = result
        else
            data.value = result.plus(data.value!!)
    }
}