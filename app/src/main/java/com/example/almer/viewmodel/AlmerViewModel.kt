package com.example.almer.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AlmerViewModel() : ViewModel() {
    var  progressBarloading = mutableStateOf(false)

    init {
        Loading()
    }

    fun Loading(){
        viewModelScope.launch {
            progressBarloading.value = true
            delay(5000L)
            progressBarloading.value = false
        }
    }
}