package com.example.tarot.domain.usecase

import android.icu.util.Calendar
import com.example.tarot.domain.repository.CardRepository

class SaveCurrentDateUseCase(private val cardRepository: CardRepository) {
    fun execute() {

        val lastdate=cardRepository.getLastDate()
        val currentdate= Calendar.DATE
        if (lastdate!==currentdate)
        {
            cardRepository.saveCurrentDate()
        }

    }
}
