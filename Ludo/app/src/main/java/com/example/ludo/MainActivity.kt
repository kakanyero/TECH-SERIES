package com.example.ludo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton=findViewById<Button>(R.id.butttoon)
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