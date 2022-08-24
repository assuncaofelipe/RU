package com.assuncao.ru.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.assuncao.ru.R
import com.assuncao.ru.databinding.ActivityFichasRefeicaoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FichasRefeicaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFichasRefeicaoBinding
    private lateinit var user: FirebaseAuth
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
        db.collection("Alunos")
            .document("9H4yPmDaTgNufH5HMIE6WJ74Ip83").get()
            .addOnSuccessListener { documento ->
                if (documento != null && documento.exists()) {
                    val dados = documento.data
                    val desjejum = dados?.get("desjejum")
                    val almoco = dados?.get("almoco")
                    val jantar = dados?.get("jantar")

                    val txt_desjejum = findViewById<TextView>(R.id.refeicao_desjejum_seg)
                    val txt_almoco = findViewById<TextView>(R.id.qtd_ficha_almoco)
                    val txt_jantar = findViewById<TextView>(R.id.qtd_ficha_jantar)

                    txt_desjejum.text = "$desjejum"
                    txt_almoco.text = "$almoco"
                    txt_jantar.text = "$jantar"

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
}








