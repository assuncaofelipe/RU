package com.assuncao.ru.services

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.assuncao.ru.R
import com.assuncao.ru.databinding.ActivityFichasRefeicaoBinding
import com.assuncao.ru.fragment.LoadingDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FichasRefeicaoActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    // refresh layout
    private lateinit var swipeRefresh: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fichas_refeicao)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)

        // Aciona a instancia do Firebase pelo db
        db = FirebaseFirestore.getInstance()

        // chama a função ouvinte de aluno
        headerStudent()

    }

    // chamase-se "ouve_aluno()" pois o metodo addOnCompleteListener
    // é um ouvinte do documento que pertence a colecao
    private fun headerStudent() {
        progressLogin()
        db.collection("Alunos")
            .document("9H4yPmDaTgNufH5HMIE6WJ74Ip83").get()
            .addOnSuccessListener { documento ->
                if (documento != null && documento.exists()) {
                    val data = documento.data
                    val desjejum = data?.get("desjejum")
                    val almoco = data?.get("almoco")
                    val jantar = data?.get("jantar")

                    val txtDesjejum = findViewById<TextView>(R.id.refeicao_desjejum_seg)
                    val txtAlmoco = findViewById<TextView>(R.id.qtd_ficha_almoco)
                    val txtJantar = findViewById<TextView>(R.id.qtd_ficha_jantar)

                    txtDesjejum.text = "$desjejum"
                    txtAlmoco.text = "$almoco"
                    txtJantar.text = "$jantar"

                } else {
                    Toast.makeText(
                        baseContext,
                        "error ao ler documento, ele não existe ou está vazio",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }.addOnFailureListener { error ->
                Toast.makeText(baseContext, "Error", Toast.LENGTH_SHORT).show()
            }
    }

    private fun progressLogin() {
        val loading = LoadingDialog(this)
        loading.startLoading()
        Handler().postDelayed(object : Runnable {
            override fun run() {
                loading.isDismiss()
            }
        }, 3000)
    }
}








