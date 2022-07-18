package com.assuncao.ru

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private val mAuthStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        var edit_email = findViewById<EditText>(R.id.edit_email)
        var edit_senha = findViewById<EditText>(R.id.edit_senha)
        var btn_login = findViewById<Button>(R.id.btnLogin)
        var ckc_mostrar_senha = findViewById<CheckBox>(R.id.ckb_mostrar_senha)

        //loginProgressBar = findViewById(R.id.progressBar);
        btn_login.setOnClickListener {
            val loginEmail = edit_email.text.toString()
            val loginSenha = edit_senha.text.toString()
            if (!TextUtils.isEmpty(loginEmail) || !TextUtils.isEmpty(loginSenha)) {
                //loginProgressBar.setVisibility(View.INVISIBLE);
                mAuth!!.signInWithEmailAndPassword(loginEmail, loginSenha)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            abrirTelaMenu()
                        } else {
                            val error = task.exception!!.message
                            Toast.makeText(this@LoginActivity, "" + error, Toast.LENGTH_SHORT)
                                .show()
                            // loginProgressBar.setVisibility(View.INVISIBLE);
                        }
                    }
            }
        }
        ckc_mostrar_senha.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                edit_senha.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                edit_senha.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }

    private fun abrirTelaMenu() {
        val intent = Intent(this@LoginActivity, MenuActivity::class.java)
        startActivity(intent)
        finish()
    }


}