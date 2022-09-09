package com.assuncao.ru.cardapios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.postDelayed
import com.assuncao.ru.R
import com.assuncao.ru.fragment.LoadingDialog
import com.google.firebase.firestore.FirebaseFirestore

class QuartaFeiraActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quarta_feira)

        // set Arrow Back to Menu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.arrow_back)

        db = FirebaseFirestore.getInstance()
        cardapioQuarta()
    }

    private fun cardapioQuarta() {
        progressLogin()
        db.collection("Cardapio")
            .document("QuartaFeira").get()
            .addOnSuccessListener { documento ->
                if (documento != null && documento.exists()) {
                    val data = documento.data

                    val desjejum = data?.get("desjejum")
                    val almoco = data?.get("almoco")
                    val jantar = data?.get("jantar")

                    val desjejumSegunda = findViewById<TextView>(R.id.refeicao_desjejum_quarta)
                    val almocoSegunda = findViewById<TextView>(R.id.refeicao_almoco_quarta)
                    val jantaSegunda = findViewById<TextView>(R.id.refeicao_jantar_quarta)

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
        Handler(Looper.getMainLooper()).postDelayed({
            run {
                loading.isDismiss()
            }
        }, 3000)
    }
}