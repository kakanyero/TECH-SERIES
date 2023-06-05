package com.example.myauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
    }
    fun btnLogin(View:View){
        val emailet=findViewById<EditText>(R.id.loginemail)
        val loginpwd=findViewById<EditText>(R.id.loginpassword)
        if (TextUtils.isEmpty(emailet.toString()) || TextUtils.isEmpty(loginpwd.toString()))
            //TextUtils is a string splitter
            Toast.makeText(this,"pleas fill all the fields",Toast.LENGTH_LONG).show()
    }else{
        auth.signInWithEmailAndPassword(emailet.toString(),loginpwd.toString()).addOnCompleteListener{
            task->
            if (task.isSuccessful){
                val intent=intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(, "please enter correct credential", Toast.LENGTH_SHORT).show()
            }
        }

    }

}
