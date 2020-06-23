package com.example.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }

        btnEntrar.setOnClickListener {
            val email = edtLoginEmail.text.toString()
            val senha = edtLoginSenha.text.toString()

            if(email.isEmpty()){
                edtLoginEmail.error = "Campo obrigatório"
                edtLoginEmail.requestFocus()
            }else if (senha.isEmpty()){
                edtLoginSenha.error = "Campo obrigatório"
                edtLoginSenha.requestFocus()
            }else{

                val minhasPreferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)
                val emailPref = minhasPreferencias.getString("KEY_EMAIL", "")
                val senhaPref = minhasPreferencias.getString("KEY_SENHA", "")

                if (email == emailPref && senha == senhaPref){
                    Toast.makeText(this@LoginActivity, "Usuario Logado", Toast.LENGTH_LONG).show()
                    val mIntent = Intent(this, MainActivity::class.java)
                    mIntent.putExtra("KEY_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                }else{
                    Toast.makeText(this@LoginActivity, "Email ou senha incorretos", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
