package com.example.aplikacjazaliczeniowa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddGradesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_grades)
        initListeners()
    }

    private fun initListeners() {
        val buttonFindSubject = findViewById<Button>(R.id.buttonFindSubject)
        buttonFindSubject.setOnClickListener(buttonFindSubjectListener)

        val buttonAddSubject = findViewById<Button>(R.id.buttonAddGrade)
        buttonAddSubject.setOnClickListener(buttonAddSubjectListener)
    }

    private val buttonFindSubjectListener = View.OnClickListener { findSubject() }


    private val buttonAddSubjectListener = View.OnClickListener { addGrade() }


    private fun findSubject() {
        val textEditSubject = findViewById<EditText>(R.id.editTextFindSubject)
        val textEditTypeSubject = findViewById<EditText>(R.id.editTextFindTypeSubject)
        val dataBaseHandler = DataBaseHandler(this, null, null, 1)
        val subject = dataBaseHandler.findSubjectWithGrades(
            textEditSubject.text.toString(),
            textEditTypeSubject.text.toString(),
        )
        if (subject != null) {
            Toast.makeText(this, "Znaleziono przedmiot", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Nie ma takiego przedmiotu", Toast.LENGTH_SHORT).show()
        }
    }

    private fun addGrade() {
        val textEditSubject = findViewById<EditText>(R.id.editTextFindSubject)
        val textEditTypeSubject = findViewById<EditText>(R.id.editTextFindTypeSubject)
        val textEditTextGrade = findViewById<EditText>(R.id.editTextAddGrade)

        val dataBaseHandler = DataBaseHandler(this, null, null, 1)

        dataBaseHandler.addGrade(
            textEditSubject.text.toString(),
            textEditTypeSubject.text.toString(),
            textEditTextGrade.text.toString()
        )


        Toast.makeText(this, "Dodano ocene", Toast.LENGTH_SHORT).show()
    }
}


