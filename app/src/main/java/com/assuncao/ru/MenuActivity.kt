package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.assuncao.ru.fragment.LoadingDialog
import com.assuncao.ru.ui.DeclaracaoQRcode
import com.assuncao.ru.ui.DiasCardapioActivity
import com.assuncao.ru.services.FichasRefeicaoActivity
import com.assuncao.ru.services.LoginActivity
import com.assuncao.ru.ui.SobreActivity
import com.google.firebase.auth.FirebaseAuth

class MenuActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private val mAuthStateListener: FirebaseAuth.AuthStateListener? = null

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
        val btnFichas = findViewById<LinearLayout>(R.id.btnFichas)
        val btnDeclaracao = findViewById<LinearLayout>(R.id.btnDeclaracao)
        val btnCardapio = findViewById<LinearLayout>(R.id.btnCardapio)
        val btnSobre = findViewById<LinearLayout>(R.id.btnSobre)

        btnFichas.setOnClickListener {
            val intent = Intent(this, FichasRefeicaoActivity::class.java)
            startActivity(intent)
        }

        btnDeclaracao.setOnClickListener {
            val intent = Intent(this, DeclaracaoQRcode::class.java)
            startActivity(intent)
        }

        btnCardapio.setOnClickListener {
            val intent = Intent(this, DiasCardapioActivity::class.java)
            startActivity(intent)
        }

        btnSobre.setOnClickListener {
            val intent = Intent(this, SobreActivity::class.java)
            startActivity(intent)
        }
    }
}