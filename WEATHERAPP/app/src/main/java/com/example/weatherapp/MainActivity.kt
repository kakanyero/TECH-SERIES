package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    private val webV:WebView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="THE WEATHER"
        val webV=findViewById<WebView>(R.id.idforthewebview)
        webV.webViewClient= WebViewClient()
        val webset=webV.settings
        webset.javaScriptEnabled = true
        //never forget =true
        webset.allowContentAccess
        webset.allowFileAccess
        webset.databaseEnabled
        webV.loadUrl("https://myportal.kyu.ac.ug/")
        webV.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webV.settings.javaScriptEnabled = true
            }
        }


    }
}