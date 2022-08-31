package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.assuncao.ru.services.FichasRefeicaoActivity
import com.assuncao.ru.services.LoginActivity
import com.assuncao.ru.ui.DeclaracaoQRcode
import com.assuncao.ru.ui.DiasCardapioActivity
import com.assuncao.ru.ui.SobreActivity
import com.google.firebase.auth.FirebaseAuth

class MenuActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        navigateActivitiesMenu()

        // saindo do apk0
        val btnLogout = findViewById<Button>(R.id.btn_sair)
        btnLogout.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        mAuth?.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun navigateActivitiesMenu() {
        val btnFichas = findViewById<CardView>(R.id.crdFichas)
        val btnCardapio = findViewById<CardView>(R.id.crdCardapio)
        val btnDeclaracao = findViewById<CardView>(R.id.crdDeclaracao)
        val btnSobre = findViewById<CardView>(R.id.crdSobre)

        btnFichas.setOnClickListener {
            val intent = Intent(this, FichasRefeicaoActivity::class.java)
            startActivity(intent)
        }

        btnCardapio.setOnClickListener {
            val intent = Intent(this, DiasCardapioActivity::class.java)
            startActivity(intent)
        }

        btnDeclaracao.setOnClickListener {
            val intent = Intent(this, DeclaracaoQRcode::class.java)
            startActivity(intent)
        }

        btnSobre.setOnClickListener {
            val intent = Intent(this, SobreActivity::class.java)
            startActivity(intent)
        }
    }
}