package com.example.tarot.presentation.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.tarot.data.repository.CardRepositoryImpl
import com.example.tarot.databinding.ActivityMainBinding
import com.example.tarot.domain.usecase.GetCardOfDayUseCase
import com.example.tarot.domain.usecase.SaveCardOfDayUSeCase
import com.example.tarot.presentation.ViewModels.MainViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel
    

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("AAA","Activity created")
        vm= ViewModelProvider(this).get(MainViewModel::class.java)
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val view=binding.root
        setContentView(view)
        val button=binding.button2
        val DayCardIntent = Intent(this, DayCardActivity::class.java)
        button.setOnClickListener {
            startActivity(DayCardIntent)
        }
    }
}