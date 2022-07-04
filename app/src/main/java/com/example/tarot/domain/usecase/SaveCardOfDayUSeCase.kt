package com.example.tarot.domain.usecase

import com.example.tarot.domain.repository.CardRepository

class SaveCardOfDayUSeCase(private val cardRepository: CardRepository) {
    fun execute(index:Int){

        cardRepository.saveCardOfDay(index)

    }
}