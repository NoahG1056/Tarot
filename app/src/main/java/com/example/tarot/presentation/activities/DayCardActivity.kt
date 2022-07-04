package com.example.tarot.presentation.activities

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.tarot.R
import com.example.tarot.data.repository.CardRepositoryImpl
import com.example.tarot.domain.usecase.*

import com.squareup.picasso.Picasso
import java.util.*

class DayCardActivity : AppCompatActivity() {
    val oblojka = "https://thumbs.dreamstime.com/b/boho-209384272.jpg"


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {

        val cardRepository = CardRepositoryImpl(context = applicationContext)
        val getIndexCardOfDayUseCase = GetIndexCardOfDayUseCase(cardRepository = cardRepository)
        val saveCardOfDayUSeCase = SaveCardOfDayUSeCase(cardRepository = cardRepository)
        val saveCurrentDate = SaveCurrentDate(cardRepository = cardRepository)
        val alreadyExistCardOfDayUseCase = AlreadyExistCardOfDayUseCase(cardRepository = cardRepository)
        val getCardOfDayUSeCase = GetCardOfDayUseCase()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_card)
        val arraimage = resources.getStringArray(R.array.image)
        val arraymean = resources.getStringArray(R.array.mean)
        val arraynames = resources.getStringArray(R.array.name)
        val name = findViewById<TextView>(R.id.NameCardTV)
        val image = findViewById<ImageView>(R.id.imageView2)
        val mean = findViewById<TextView>(R.id.MeanCardTV)

        //proverka
        if (alreadyExistCardOfDayUseCase.execute()) {
            val index = getIndexCardOfDayUseCase.execute()
            Picasso.get().load(arraimage[index]).resize(800, 1200).into(image)
            mean.setText(arraymean[index])
            name.setText(arraynames[index])
            name.visibility = View.VISIBLE
            mean.visibility = View.VISIBLE

        } else {
            Picasso.get().load(oblojka).resize(800, 1200).into(image)
            image.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scalealpha))
            image.setOnClickListener {
                val card = getCardOfDayUSeCase.execute()
                saveCardOfDayUSeCase.execute(card)
                saveCurrentDate.execute()
                Picasso.get().load(arraimage[card]).resize(800, 1200).into(image)
                image.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scalealpha))
                mean.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scalealpha))
                mean.setText(arraymean[card])
                mean.visibility = View.VISIBLE
                image.isClickable = false
                name.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scalealpha))
                name.setText(arraynames[card])
            }
        }
    }
}