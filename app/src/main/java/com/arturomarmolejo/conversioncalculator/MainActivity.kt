package com.arturomarmolejo.conversioncalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arturomarmolejo.conversioncalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.text.NumberFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener { calculateConversion() }
    }

    private fun calculateConversion() {
        val stringInTextField = binding.mInput.text.toString()
        val inputAmount: Double? = stringInTextField.toDoubleOrNull()

        if(inputAmount==null){
            binding.convertResultText.text = ""
            return
        }

        val longitudeEvaluation: Double = when (binding.longitudeOptions.checkedRadioButtonId) {
            R.id.option_mm_button -> 1000.00
            R.id.option_cm_button -> 100.00
            R.id.option_km_button -> 0.001
            R.id.option_in_button -> 39.3701
            else -> 3.28084
        }

        var convertedResult = inputAmount * longitudeEvaluation
        binding.convertResultText.text = convertedResult.toString()

    }
}