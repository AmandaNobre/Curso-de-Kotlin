package com.example.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        wbvSite.settings.javaScriptEnabled = true
        wbvSite.loadUrl("http://cellep.com/estacaohack")
        wbvSite.webViewClient = WebViewClient()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

}
