package com.example.aplikacjazaliczeniowa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {

        val buttonFirst = findViewById<Button>(R.id.button)
        buttonFirst.setOnClickListener(buttonFirstListener)

        val buttonSecond = findViewById<Button>(R.id.button2)
        buttonSecond.setOnClickListener(buttonSecondListener)

        val buttonFifth = findViewById<Button>(R.id.button5)
        buttonFifth.setOnClickListener(buttonFifthListener)

        val buttonSix = findViewById<Button>(R.id.button6)
        buttonSix.setOnClickListener(buttonSixthListener)

        val buttonAvarage = findViewById<Button>(R.id.buttonAvarage)
        buttonAvarage.setOnClickListener(buttonAvarageListener)
    }

    private val buttonFirstListener = View.OnClickListener { callFirst() }
    private val buttonSecondListener = View.OnClickListener { callSecond() }
    private val buttonFifthListener = View.OnClickListener { callThird() }
    private val buttonSixthListener = View.OnClickListener { callSix() }
    private val buttonAvarageListener = View.OnClickListener { callAvarage() }

    private fun callAvarage() {
        val intentAvarage = Intent(this, AvarageActivity::class.java)
        startActivity(intentAvarage)
    }

    private fun callSix() {
        val sixthIntent = Intent(this, AddGradesActivity::class.java)
        startActivity(sixthIntent)
    }

    private fun callThird() {
        val thirdIntent = Intent(this, AddSbujectsActivity::class.java)
        startActivity(thirdIntent)
    }

    private fun callSecond() {
        val secondIntent = Intent(this, DisplayGradesActivity::class.java)
        startActivity(secondIntent)
    }

    private fun callFirst() {
        val firstIntent = Intent(this, DisplayScheduleActivity::class.java)
        startActivity(firstIntent)
    }
}