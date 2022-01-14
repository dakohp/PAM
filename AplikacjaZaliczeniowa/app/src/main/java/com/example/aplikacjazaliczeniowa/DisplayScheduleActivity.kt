package com.example.aplikacjazaliczeniowa

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display_schedule.*


class DisplayScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_schedule)
        initListeners()
        displaySchedule()
    }

    private fun initListeners() {
        val buttonThird = findViewById<Button>(R.id.button3)
        buttonThird.setOnClickListener(buttonThirdListener)
    }

    private val buttonThirdListener = View.OnClickListener { callThird() }

    private fun callThird() {
        val thirdIntent = Intent(this, AddSbujectsActivity::class.java)
        startActivity(thirdIntent)
    }


    private fun displaySchedule() {
        val dataBaseHandler = DataBaseHandler(this, null, null, 1)

        val subject = dataBaseHandler.findSubjectWithoutGrades()
        var i = 0

        if (subject != null) {

            while (i < subject.size) {

                val newTextView = TextView(this)
                val newTextView2 = TextView(this)

                newTextView.text = (
                        subject[i].time + " " + subject[i].room
                        )
                newTextView2.text = (
                        subject[i].subject + " " + subject[i].typeSubject
                        )

                newTextView.textSize = 15F
                newTextView.gravity = Gravity.CENTER

                newTextView2.textSize = 15F
                newTextView2.gravity = Gravity.CENTER

                when (subject[i].dayOfWeek) {
                    "Poniedziałek", "poniedziałek" -> {
                        layoutMonday.addView(newTextView)
                        layoutMonday.addView(newTextView2)
                    }
                    "Wtorek", "wtorek" -> {
                        layoutTuesday.addView(newTextView)
                        layoutTuesday.addView(newTextView2)
                    }
                    "Środa", "środa" -> {
                        layoutWednesday.addView(newTextView)
                        layoutWednesday.addView(newTextView2)
                    }
                    "Czwartek", "czwartek" -> {
                        layoutThursday.addView(newTextView)
                        layoutThursday.addView(newTextView2)
                    }
                    "Piątek", "piątek" -> {
                        layoutFriday.addView(newTextView)
                        layoutFriday.addView(newTextView2)
                    }
                }
                i++
            }
        }
    }

}