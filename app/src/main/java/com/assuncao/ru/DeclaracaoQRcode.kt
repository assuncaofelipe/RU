package com.assuncao.ru

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assuncao.ru.databinding.ActivityDeclaracaoQrcodeBinding
import com.google.firebase.auth.FirebaseAuth

class DeclaracaoQRcode : AppCompatActivity() {

    private lateinit var binding: ActivityDeclaracaoQrcodeBinding
    private lateinit var user: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeclaracaoQrcodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = FirebaseAuth.getInstance()

        if (user.currentUser != null) {
            user.currentUser?.let {
                binding.txtResultEmail.text = it.email
            }
        }



    }
}