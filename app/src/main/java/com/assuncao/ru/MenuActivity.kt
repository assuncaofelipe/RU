package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        var imageFichas = findViewById<ImageView>(R.id.ivFichas)
        var imageDeclaracao = findViewById<ImageView>(R.id.ivdeclaracao)

        imageFichas.setOnClickListener {
            openFichasActivity()
        }

        imageDeclaracao.setOnClickListener{
            openTelaDeclaracao()
        }
    }

    private fun openFichasActivity() {
        val intent = Intent(this, FichasRefeicaoActivity::class.java)
        startActivity(intent)
    }

    fun openCardapioActivity() {

    }

    private fun openTelaDeclaracao() {
        val intent = Intent(this, DeclaracaoQRcode::class.java)
        startActivity(intent)
    }

    fun sobre() {

    }
}