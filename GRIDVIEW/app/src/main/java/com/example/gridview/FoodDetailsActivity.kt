package com.example.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FoodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        var bundle=intent.extras
        findViewById<ImageView>(R.id.imageView2).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.textView2).text=bundle!!.getString("name")
        findViewById<TextView>(R.id.textView3).text=bundle!!.getString("des")
    }
}