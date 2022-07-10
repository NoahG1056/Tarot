package com.example.tarot.app.di

import com.example.tarot.data.repository.CardRepositoryImpl
import com.example.tarot.domain.repository.CardRepository
import org.koin.dsl.module

val dataModule= module {

    single<CardRepository> {
        CardRepositoryImpl(context = get())
    }
}