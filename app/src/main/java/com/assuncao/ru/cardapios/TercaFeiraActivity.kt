package com.assuncao.ru.cardapios

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assuncao.ru.R

class TercaFeiraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terca_feira)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)
    }
}