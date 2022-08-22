package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MenuActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private val mAuthStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        clickListener()

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

    private fun clickListener() {
        val btnFichas = findViewById<LinearLayout>(R.id.btnFichas)
        val btnDeclaracao = findViewById<LinearLayout>(R.id.btnDeclaracao)
        val btnCardapio = findViewById<LinearLayout>(R.id.btnCardapio)
        val btnSobre = findViewById<LinearLayout>(R.id.btnSobre)

        btnFichas.setOnClickListener {
            openFichasActivity()
        }

        btnDeclaracao.setOnClickListener{
            openTelaDeclaracao()
        }

        btnCardapio.setOnClickListener{
            openCardapioActivity()
        }

        btnSobre.setOnClickListener{
            openSobre()
        }

    }

    private fun openFichasActivity() {
        val intent = Intent(this, FichasRefeicaoActivity::class.java)
        startActivity(intent)
    }

    fun openCardapioActivity() {
        val intent = Intent(this, CardapioActivity::class.java)
        startActivity(intent)
    }

    private fun openTelaDeclaracao() {
        val intent = Intent(this, DeclaracaoQRcode::class.java)
        startActivity(intent)
    }

    fun openSobre() {
        val intent = Intent(this, SobreActivity::class.java)
        startActivity(intent)
    }
}