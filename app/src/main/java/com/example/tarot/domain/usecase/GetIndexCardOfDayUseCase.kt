package com.example.tarot.domain.usecase

import com.example.tarot.domain.repository.CardRepository

class GetIndexCardOfDayUseCase(private val cardRepository: CardRepository) {
    fun execute():Int{
        return cardRepository.getIndexCardOfDay()
    }
}