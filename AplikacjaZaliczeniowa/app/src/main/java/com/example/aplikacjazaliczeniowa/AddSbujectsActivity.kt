package com.example.aplikacjazaliczeniowa

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView


class AddSbujectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subjects)

        initListeners()

        editTextVariable()

    }

    private fun initListeners() {
        val buttonAdd = findViewById<Button>(R.id.buttonAddSubject)
        buttonAdd.setOnClickListener(buttonAddListeners)

        val buttonDelete = findViewById<Button>(R.id.buttonDeleteSubject)
        buttonDelete.setOnClickListener(buttonDeleteListeners)
    }

    private val buttonDeleteListeners = View.OnClickListener { deleteSubject() }
    private val buttonAddListeners = View.OnClickListener { addSubject() }


    private fun editTextVariable() {

        val getTypeSubject = findViewById<AutoCompleteTextView>(R.id.editTextTypeSubject)
        val typeSubject = resources.getStringArray(R.array.TypeSubject)
        val adapterTypeSubject =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, typeSubject)
        getTypeSubject.setAdapter(adapterTypeSubject)

        val getDayOfWeek = findViewById<AutoCompleteTextView>(R.id.editTextDayOfWeek)
        val days = resources.getStringArray(R.array.Day)
        val adapterDay = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, days)
        getDayOfWeek.setAdapter(adapterDay)

        val getTime1 = findViewById<AutoCompleteTextView>(R.id.editTextTime1)
        val times = resources.getStringArray(R.array.Time)
        val adapterTime1 = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, times)
        getTime1.setAdapter(adapterTime1)

        val getTime2 = findViewById<AutoCompleteTextView>(R.id.editTextTime2)
        val adapterTime2 = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, times)
        getTime2.setAdapter(adapterTime2)
    }

    @SuppressLint("SetTextI18n")
    private fun addSubject() {

        val getSurname = findViewById<EditText>(R.id.editTextSurname)
        val getName = findViewById<EditText>(R.id.editTextName)
        val getSubject = findViewById<EditText>(R.id.editTextSubject)
        val getTypeSubject = findViewById<AutoCompleteTextView>(R.id.editTextTypeSubject)
        val getDayOfWeek = findViewById<AutoCompleteTextView>(R.id.editTextDayOfWeek)
        val getTime1 = findViewById<AutoCompleteTextView>(R.id.editTextTime1)
        val getTime2 = findViewById<AutoCompleteTextView>(R.id.editTextTime2)
        val getRoom = findViewById<EditText>(R.id.editTextRoom)

        val time = EditText(this)
        time.setText(getTime1.text.toString() + " - " + getTime2.text.toString())

        val dataBaseHandler = DataBaseHandler(this, null, null, 1)

        val subject = Subject(

            getSurname.text.toString(),
            getName.text.toString(),
            getSubject.text.toString(),
            getTypeSubject.text.toString(),
            getDayOfWeek.text.toString(),
            time.text.toString(),
            getRoom.text.toString()
        )

        dataBaseHandler.addSubject(subject)
        Toast.makeText(this, "Dodano", Toast.LENGTH_SHORT).show()
    }

    fun deleteSubject() {
        val getSubject = findViewById<EditText>(R.id.editTextSubject)
        val getTypeSubject = findViewById<AutoCompleteTextView>(R.id.editTextTypeSubject)

        val dataBaseHandler = DataBaseHandler(this, null, null, 1)

        val result = dataBaseHandler.deleteSubject(
            getSubject.text.toString(),
            getTypeSubject.text.toString()
        )
        if (result) {
            Toast.makeText(this, "Usunięte", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Usunięte", Toast.LENGTH_SHORT).show()
        }
    }
}


