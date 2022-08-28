package com.assuncao.ru.cardapios

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.assuncao.ru.R
import com.assuncao.ru.fragment.LoadingDialog
import com.google.firebase.firestore.FirebaseFirestore

class SegundaFeiraActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_feira)

        // set White Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)

        db = FirebaseFirestore.getInstance()
        cardapioSegunda()

    }

    private fun cardapioSegunda() {
        progressLogin()
        db.collection("Cardapio")
            .document("SegundaFeira").get()
            .addOnSuccessListener { documento ->
                if (documento != null && documento.exists()) {
                    val data = documento.data

                    val desjejum = data?.get("desjejum")
                    val almoco = data?.get("almoco")
                    val jantar = data?.get("jantar")

                    val desjejumSegunda = findViewById<TextView>(R.id.refeicao_desjejum_seg)
                    val almocoSegunda = findViewById<TextView>(R.id.refeicao_almoco_seg)
                    val jantaSegunda = findViewById<TextView>(R.id.refeicao_jantar_seg)

                    desjejumSegunda.text = "$desjejum"
                    almocoSegunda.text = "$almoco"
                    jantaSegunda.text = "$jantar"
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