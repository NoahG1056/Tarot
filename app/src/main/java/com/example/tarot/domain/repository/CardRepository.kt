package com.example.tarot.domain.repository

interface CardRepository {
    fun saveCurrentDate()
    fun getLastDate():Int
    fun saveCardOfDay(index:Int)
    fun getIndexCardOfDay():Int
}