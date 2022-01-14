package com.example.aplikacjazaliczeniowa

//import kotlinx.android.synthetic.main.activity_.view.*
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display_grades.*

class DisplayGradesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_grades)
        displayGrades()
    }

    private fun displayGrades() {
        val dataBaseHandler = DataBaseHandler(this, null, null, 1)
        val subjectWithGrades = dataBaseHandler.showGrades()
        var i = 0
        if (subjectWithGrades != null) {

            while (i < subjectWithGrades.size) {

                val newTextView = TextView(this)
                val newTextView2 = TextView(this)

                newTextView.text = (
                        subjectWithGrades[i].subject + " " +
                                subjectWithGrades[i].typeSubject

                        )
                newTextView2.text = (
                        subjectWithGrades[i].surname + " " +
                                subjectWithGrades[i].name + " " +
                                subjectWithGrades[i].grade
                        )

                layoutGradesInside.addView(newTextView)
                layoutGradesInside.addView(newTextView2)

                i++
            }
        }

    }
}