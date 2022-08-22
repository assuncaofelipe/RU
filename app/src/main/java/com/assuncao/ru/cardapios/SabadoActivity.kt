package com.assuncao.ru.cardapios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assuncao.ru.R

class SabadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sabado)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)
    }
}