package com.example.fragments.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val logLiveData = MutableLiveData<ArrayList<String>?>()
    fun setLog(value: String) {
        logLiveData.value?.add(value)
    }

    fun clearLogs() {
        logLiveData.value?.clear()
    }
}