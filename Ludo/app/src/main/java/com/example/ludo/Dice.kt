package com.example.ludo

class Dice(private val numsides: Int) {
    fun roll(): Int{
        return (1..numsides).random()
    }

}
