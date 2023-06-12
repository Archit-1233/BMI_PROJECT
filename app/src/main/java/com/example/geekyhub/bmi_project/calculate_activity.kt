package com.example.geekyhub.bmi_project

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class calculate_activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)
        supportActionBar?.hide()
        val etWeight=findViewById<EditText>(R.id.etWeight)
        val etHeight=findViewById<EditText>(R.id.etHeight)
        val calculateBmi=findViewById<Button>(R.id.calculate_bmi)
        val resultTvBmi=findViewById<TextView>(R.id.resultTv_bmi)
        val statusBmi=findViewById<TextView>(R.id.bmi_status)
        val bmiTv=findViewById<TextView>(R.id.bmi_tv)
        val reset=findViewById<Button>(R.id.reset)
        calculateBmi.setOnClickListener() {
            if (etWeight.text.isNotEmpty()|| etWeight.text.isNotEmpty()) {
                val getWeight = etWeight.text.toString().toFloat()
                val getHeight = etHeight.text.toString().toFloat()
                val result: Float = (getWeight) / (getHeight * getHeight)
                resultTvBmi.text = result.toString()

                resultTvBmi.visibility = View.VISIBLE

                if (result < 18.5) {
                    statusBmi.text = "Underweight"
                } else if (result >= 18.5 && result < 24.9) {
                    statusBmi.text = "Healthy"
                } else if (result >= 24.9 && result < 30) {
                    statusBmi.text = "Overweight"
                } else if (result >= 30) {
                    statusBmi.text = "Suffering from obesity"
                }

                statusBmi.visibility = View.VISIBLE
                reset.visibility=Button.VISIBLE }
            else {
            Toast.makeText(this, "please enter valid data", Toast.LENGTH_SHORT).show()
        }

        }
        reset.setOnClickListener(){
            etWeight.text.clear()
            etHeight.text.clear()

            statusBmi.text=" "
            resultTvBmi.text=" "
            reset.visibility=View.GONE
        }


    }
}