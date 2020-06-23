package com.example.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Executar uma a ção após determinado tempo
        Handler().postDelayed({
            //Intent
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        },3000)
    }
}
