package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.assuncao.ru.services.FichasRefeicaoActivity
import com.assuncao.ru.services.LoginActivity
import com.assuncao.ru.ui.DeclaracaoQRcode
import com.assuncao.ru.ui.DiasCardapioActivity
import com.assuncao.ru.ui.SobreActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MenuActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private val sb: StringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        navigateActivitiesMenu()

        // saindo do apk0
        val btnLogout = findViewById<Button>(R.id.btn_sair)
        val user = Firebase.auth.currentUser
        if (user != null) {
            btnLogout.setOnClickListener {
                mAuth?.signOut();
                onDestroy();
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        sb.append("\n onDestroy Called")
        Log.d("ACTIVITY_LIFECYCLE", "onDestroy Called")
        finish()
    }

    private fun logout() {

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