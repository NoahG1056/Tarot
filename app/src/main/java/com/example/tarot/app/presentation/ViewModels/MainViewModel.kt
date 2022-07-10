package com.example.tarot.app.presentation.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    fun openCardOfDay(){

    }

    init {
        Log.d("AAA","VM created")
    }

    override fun onCleared() {
        Log.d("AAA","VM cleared")
        super.onCleared()

    }
}