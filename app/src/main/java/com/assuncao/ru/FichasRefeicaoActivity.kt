package com.assuncao.ru

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assuncao.ru.databinding.ActivityFichasRefeicaoBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.okhttp.internal.Util

class FichasRefeicaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFichasRefeicaoBinding
    private lateinit var user: FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFichasRefeicaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)

        user = FirebaseAuth.getInstance()
        if (user.currentUser != null) {
            user.currentUser?.let {
                binding.tvResultUser.text = it.email
            }
        }
        db = FirebaseFirestore.getInstance()

        // chama o ouvinte de aluno
        ouve_aluno()

    }

    // chamase-se "ouve_aluno()" pois o metodo addOnCompleteListener
    // é um ouvinte do documento que pertence a colecao
    private fun ouve_aluno() {

        db.collection("Alunos")
            .document("9H4yPmDaTgNufH5HMIE6WJ74Ip83").get()
            .addOnSuccessListener { documento ->

                if ( documento != null && documento.exists()) {
                    val dados = documento.data
                    val desjejum = dados?.get("desjejum")
                    val almoco = dados?.get("almoco")
                    val jantar = dados?.get("jantar")

                    var txt_desjejum = findViewById<TextView>(R.id.tv_qtd_desjejum)
                    var txt_almoco = findViewById<TextView>(R.id.tv_qtd_almoco)
                    var txt_jantar = findViewById<TextView>(R.id.tv_qtd_jantar)

                    txt_desjejum.setText("$desjejum")
                    txt_almoco.setText("$almoco")
                    txt_jantar.setText("$jantar")

                } else {
                    Toast.makeText(baseContext, "error ao ler documento, ele não existe ou está vazio", Toast.LENGTH_SHORT).show()
                }

            }.addOnFailureListener { error ->
                Toast.makeText(baseContext, "Error", Toast.LENGTH_SHORT).show()
            }


    }
}








