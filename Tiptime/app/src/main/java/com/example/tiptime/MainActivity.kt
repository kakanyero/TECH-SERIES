package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {
            calculateTip()
            //now let us clear the prompt after typing the
            // cost of service using the clear method
            binding.costOfService.text.clear()
        }
    }
    fun calculateTip(){
        val stringInTextField=binding.costOfService.text
        // note that toDouble() works only on strings so u have to first
        // convert the text toString() first and then to double
        val cost=stringInTextField.toString().toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        val selectedId=binding.tipOptions.checkedRadioButtonId
        val tipPercentage=when(selectedId){
            R.id.option_twenty_percent->0.02
            R.id.option_eighteen_percent->0.18
            else->0.15
        }
        var tip=tipPercentage*cost
        if (binding.roundUpSwitch.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        val formattedTip=NumberFormat.getInstance().format(tip)
        binding.tipResult.text=getString(R.string.tip_amount, formattedTip)

    }
}