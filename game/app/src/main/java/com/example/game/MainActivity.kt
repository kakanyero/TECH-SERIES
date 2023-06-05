package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    //we are creating the variables for the ads
    lateinit var adView: AdView
    lateinit var adRequest: AdRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //we are initialising our variables we created
        MobileAds.initialize(this)
        //Initialising our ad with the id
        adView=findViewById(R.id.adView2)
        //initialising our ad request
        adRequest=AdRequest.Builder().build()
        //we are now loading our app with app ad request
        adView.loadAd(adRequest)


        val rollButton=findViewById<Button>(R.id.button)
        rollButton.setOnClickListener{rollDice()}
        //do a roll when the app starts

    }
    private fun rollDice(){
        //create new dice object with 6 sides and rol it
        val dice=Dice(6)
        val diceRoll=dice.roll()
        //find image in the layout
        val diceImage=findViewById<ImageView>(R.id.ivdice)

        //determine which drawableResource id to use based on the dice
        val drawableResource=when(diceRoll){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else ->R.drawable.dice_6
        }
        //update imageview with
        diceImage.setImageResource(drawableResource)
        //update the content description
        diceImage.contentDescription=diceRoll.toString()
    }

}