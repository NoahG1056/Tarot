package com.example.tarot.domain.usecase

import com.example.tarot.domain.repository.CardRepository
import java.util.*

class AlreadyExistCardOfDayUseCase(private val cardRepository: CardRepository) {

    fun execute(): Boolean {
        if (Calendar.DATE == cardRepository.getLastDate()) {
            return true
        }
        return false
    }
}