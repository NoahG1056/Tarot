package com.example.tarot.app.presentation.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.tarot.databinding.ActivityMainBinding
import com.example.tarot.app.presentation.ViewModels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm by viewModel<MainViewModel>()
    

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("AAA","Activity created")
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