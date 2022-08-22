package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.assuncao.ru.cardapios.SegundaFeiraActivity
import com.assuncao.ru.cardapios.TercaFeiraActivity

class DiasCardapioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dias_semana)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)

        chamaActivities()

    }

    private fun chamaActivities(){
        //chamando funções cardapio
        openSegundaFeira()
        openTercaFeira()
    }

    private fun openSegundaFeira() {
        val segundaFeira = findViewById<CardView>(R.id.card_segunda_feira)
        segundaFeira.setOnClickListener {
            val intent = Intent(this, SegundaFeiraActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openTercaFeira() {
        val tercaFeira = findViewById<CardView>(R.id.card_terca_feira)
        tercaFeira.setOnClickListener {
            val intent = Intent(this, TercaFeiraActivity::class.java)
            startActivity(intent)
        }
    }
}