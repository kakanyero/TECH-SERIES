package com.example.bottomanddrawer

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class SplashFragment : AppCompatActivity() {

    private val SPLASH_TIME_OUT=4000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)
        Handler().postDelayed({
            val i=Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },SPLASH_TIME_OUT)

    }

}