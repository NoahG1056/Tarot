package com.example.tarot.data.repository

import android.content.Context
import android.util.Log
import com.example.tarot.domain.repository.CardRepository
import java.util.*

private const val SHARED_PREFS_NAME="shared_prefs_name"
private const val KEY_LAST_DATE="last_date"
private const val CURRENT_DATE=Calendar.DATE
private const val INDEX_DAY_CARD="index"


class CardRepositoryImpl(private val context:Context):CardRepository {
    private val sharedPreferences=context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)
    override fun getLastDate():Int {
        val result=sharedPreferences.getInt(KEY_LAST_DATE, CURRENT_DATE)
        return result
        Log.d("AAA","Данные получены $result")

    }

    override fun saveCardOfDay(index:Int) {
        sharedPreferences.edit().putInt(INDEX_DAY_CARD,index).apply()
        Log.d("AAA","карта сохранена под индексом $index")
    }

    override fun getIndexCardOfDay():Int {
        val result=sharedPreferences.getInt(INDEX_DAY_CARD,0)
        return result
        Log.d("AAA","индекс карты $result")

    }

    override fun saveCurrentDate() {
        Log.d("AAA","Save current_date$CURRENT_DATE")
        sharedPreferences.edit().putInt(KEY_LAST_DATE, CURRENT_DATE).apply()
    }

}

