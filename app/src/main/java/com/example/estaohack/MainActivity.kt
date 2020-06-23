package com.example.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("KEY_EMAIL")
        val minhasPreferencias = getSharedPreferences( "cadastro-$email", Context.MODE_PRIVATE)
        val nome = minhasPreferencias.getString("KEY_NOME",  "Não encontrado")
        val sobrenome = minhasPreferencias.getString("KEY_NOME", "Nâo encontrado")
        val genero = minhasPreferencias.getString("KEY_GENERO", "Nâo encontrado")

        txvNome.text = "$nome $sobrenome"
        txvEmail.text = email
        txvGenero.text = genero

        btnSair.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }

        btnSite.setOnClickListener {
            val  mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }

    }
}
