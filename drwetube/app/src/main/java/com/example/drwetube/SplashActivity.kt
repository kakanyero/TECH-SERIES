package com.example.drwetube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val sto=4000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //splash screen without the launcher option selected in the mani menu
        Handler().postDelayed({
            val i=Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },sto)
    }
}