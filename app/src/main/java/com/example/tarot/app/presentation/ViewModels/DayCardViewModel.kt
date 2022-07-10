package com.example.tarot.app.presentation.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tarot.domain.usecase.*

class DayCardViewModel(
    private val alreadyExistCardOfDayUseCase: AlreadyExistCardOfDayUseCase,
    private val generateIndexCardUSeCase:GenerateIndexCardUseCase,
    private val getIndexCardOfDayUseCase: GetIndexCardOfDayUseCase,
    private val saveCardOfDayUSeCase: SaveCardOfDayUSeCase,
    private val saveCurrentDateUseCase: SaveCurrentDateUseCase):ViewModel() {

    val nameLive=MutableLiveData<String>()
    val imageLive=MutableLiveData<String>()
    val meanLive=MutableLiveData<String>()


    fun IsCardAlreadyExist():Boolean{
        return alreadyExistCardOfDayUseCase.execute()
    }
}