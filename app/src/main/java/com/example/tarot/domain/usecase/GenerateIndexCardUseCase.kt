package com.example.tarot.domain.usecase


class GenerateIndexCardUseCase() {
    fun execute(): Int {
        val max = 20
        return (0..max).random()
    }
}