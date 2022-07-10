package com.example.tarot.app.di

import com.example.tarot.domain.usecase.*
import org.koin.dsl.module

val domainModule= module {
    factory<AlreadyExistCardOfDayUseCase> {
        AlreadyExistCardOfDayUseCase(cardRepository = get())
    }
    factory<GenerateIndexCardUseCase> {
        GenerateIndexCardUseCase()
    }
    factory<GetIndexCardOfDayUseCase> {
        GetIndexCardOfDayUseCase(cardRepository = get())
    }
    factory<SaveCurrentDateUseCase> {
        SaveCurrentDateUseCase(cardRepository =get() )
    }
    factory<SaveCardOfDayUSeCase> {
        SaveCardOfDayUSeCase(cardRepository = get())
    }

}