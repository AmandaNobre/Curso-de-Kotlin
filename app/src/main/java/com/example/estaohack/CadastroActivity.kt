package com.example.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val listaGenero = arrayOf("Selecione o gênero", "Feminino", "Masculino", "outros")
        val spinerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listaGenero)
        spnGenero.adapter = spinerAdapter

        btnCadastroCadastrar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim()
            val senha = edtCadastroSenha.text.toString().trim()
            var genero = ""

            if (spnGenero.selectedItemId != 0L){
                genero = spnGenero.selectedItem.toString()
            }

            if(nome.isEmpty() ||
                sobrenome.isEmpty() ||
                email.isEmpty()  ||
                senha.isEmpty()){
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG)
                    .show()
            }else{
                val preferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)
                preferencias.edit().apply{
                    putString("KEY_NOME", nome)
                    putString("KEY_SOBRENOME", sobrenome)
                    putString("KEY_EMAIL", email)
                    putString("KEY_SENHA", senha)
                    putString("KEY_GENERO", genero)
                }.apply()
                val mIntent = Intent(this, MainActivity::class.java)
                mIntent.putExtra("KEY_EMAIL", email)
                startActivity(mIntent)
                finishAffinity()
            }
        }
    }
}
