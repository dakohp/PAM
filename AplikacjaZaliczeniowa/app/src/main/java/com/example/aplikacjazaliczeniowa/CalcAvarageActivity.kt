package com.example.aplikacjazaliczeniowa

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.StringBuilder

class CalcAvarageActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_avarage)
        setAvarageAndGrades()
    }
    private fun setAvarageAndGrades() {
        val result = findViewById<TextView>(R.id.textViewResultAvarage)
        val sumGrade = findViewById<TextView>(R.id.textViewGradesAvarage)

        val intent = this.intent
        val liczba = intent.getDoubleArrayExtra("Ocena")

        var sum = 0.0
        val stringBuilder = StringBuilder()
        if (liczba != null) {
            for (extra in liczba) {
                sum += extra
                stringBuilder.append(extra.toString()).append(", ")
            }
        }
        sum /= liczba!!.size
        sumGrade.text = "$stringBuilder"
        result.text = "$sum"
    }

}



