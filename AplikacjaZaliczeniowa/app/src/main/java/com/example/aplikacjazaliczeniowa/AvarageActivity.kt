package com.example.aplikacjazaliczeniowa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvarageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avarage)
        initListeners()

    }

    private fun initListeners() {
        val buttonAddToAvarage = findViewById<Button>(R.id.buttonAddToAvarage)
        buttonAddToAvarage.setOnClickListener(addToAvarageListener)

        val buttonCalculateAvarage = findViewById<Button>(R.id.buttonCalculateAvarage)
        buttonCalculateAvarage.setOnClickListener(calculateAvarageListener)
    }

    private val addToAvarageListener = View.OnClickListener { addToAvarage() }
    private val calculateAvarageListener = View.OnClickListener { callCalcuateAvarage() }

    var gradesArray = ArrayList<Double>()

    private fun callCalcuateAvarage() {
        val calcAvarageIntent = Intent(this, CalcAvarageActivity::class.java)
        calcAvarageIntent.putExtra("Ocena", gradesArray.toDoubleArray())
        startActivity(calcAvarageIntent)
    }

    private fun addToAvarage() {
        val editTextGrade = findViewById<EditText>(R.id.editTextGradeAv)
        gradesArray.add(editTextGrade.text.toString().toDouble())
        Toast.makeText(this, "Dodano", Toast.LENGTH_SHORT).show()
    }

}
