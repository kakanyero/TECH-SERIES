package com.example.ch13appbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity2 : AppCompatActivity() {
    private val SPLASH_TIME_OUT=4000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //putting the real splash screen now in our application...........
        Handler().postDelayed({

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },SPLASH_TIME_OUT)
    }
}