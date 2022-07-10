package com.example.tarot.app.di

import com.example.tarot.app.presentation.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel<MainViewModel>{
        MainViewModel()
    }
}