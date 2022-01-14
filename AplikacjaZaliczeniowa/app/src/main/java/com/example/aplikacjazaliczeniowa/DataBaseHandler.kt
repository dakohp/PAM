package com.example.aplikacjazaliczeniowa

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHandler(
    context: Context,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {


    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "subcjetUniversity.db"
        val TABLE_SUBJECTS = "subcjets"
        val COLUMN_ID = "id"
        val COLUMN_NAME = "name"
        val COLUMN_SURNAME = "surname"
        val COLUMN_SUBJECT = "subject"
        val COLUMN_TYPESUBJECT = "type_subject"
        val COLUMN_DAYOFWEEK = "day_of_week"
        val COLUMN_TIME = "time"
        val COLUMN_ROOM = "room"
        val COLUMN_GRADE = "grade"
    }

    override fun onCreate(database: SQLiteDatabase?) {
        val CREATE_SUBJECTS_TABLE = ("CREATE TABLE " +
                TABLE_SUBJECTS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SURNAME + " TEXT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_SUBJECT + " TEXT,"
                + COLUMN_TYPESUBJECT + " TEXT,"
                + COLUMN_DAYOFWEEK + " TEXT,"
                + COLUMN_TIME + " TEXT,"
                + COLUMN_ROOM + " TEXT,"
                + COLUMN_GRADE + " DOUBLE" + ")"
                )
        database?.execSQL(CREATE_SUBJECTS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_SUBJECTS")
        onCreate(db)
    }

    fun addSubject(subject: Subject) {
        val data = ContentValues()
        data.put(COLUMN_SURNAME, subject.surname)
        data.put(COLUMN_NAME, subject.name)
        data.put(COLUMN_SUBJECT, subject.subject)
        data.put(COLUMN_TYPESUBJECT, subject.typeSubject)
        data.put(COLUMN_DAYOFWEEK, subject.dayOfWeek)
        data.put(COLUMN_TIME, subject.time)
        data.put(COLUMN_ROOM, subject.room)

        val database = this.writableDatabase
        database.insert(TABLE_SUBJECTS, null, data)
        database.close()
    }

    fun addGrade(textSubject: String, textTypeSubject: String, textEditTextGrade: String) {
        val data = ContentValues()

        data.put(COLUMN_GRADE, textEditTextGrade)

        val selection = "$COLUMN_SUBJECT LIKE ? AND $COLUMN_TYPESUBJECT LIKE ?"

        val database = this.writableDatabase
        database.update(
            TABLE_SUBJECTS, data, selection, arrayOf(textSubject, textTypeSubject)
        )
        database.close()
    }

    fun findSubjectWithoutGrades(): MutableList<Subject>? {
        val query =
            "SELECT * from $TABLE_SUBJECTS"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var subs: MutableList<Subject>? = mutableListOf()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0).toInt()
                val surname = cursor.getString(1)
                val name = cursor.getString(2)
                val subject = cursor.getString(3)
                val typeSubject = cursor.getString(4)
                val dayOfWeek = cursor.getString(5)
                val time = cursor.getString(6)
                val room = cursor.getString(7)

                subs?.add(
                    Subject(
                        id,
                        surname,
                        name,
                        subject,
                        typeSubject,
                        dayOfWeek,
                        time,
                        room,
                    )
                )
            } while (cursor.moveToNext())

            cursor.close()
        }
        db.close()
        return subs
    }

    fun findSubjectWithGrades(textEditSubject: String, textEditTypeSubject: String): Subject? {
        val query = "SELECT * from $TABLE_SUBJECTS WHERE $COLUMN_SUBJECT  = \"$textEditSubject\"" +
                "and $COLUMN_TYPESUBJECT  = \"$textEditTypeSubject\""


        val database = this.writableDatabase
        val cursor = database.rawQuery(query, null)
        var subject: Subject? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()
            val id = cursor.getString(0).toInt()
            val surname = cursor.getString(1)
            val name = cursor.getString(2)
            val subjectUniversity = cursor.getString(3)
            val typeSubject = cursor.getString(4)
            val weekOfDay = cursor.getString(5)
            val time = cursor.getString(6)
            val room = cursor.getString(7)


            subject = Subject(
                id,
                surname,
                name,
                subjectUniversity,
                typeSubject,
                weekOfDay,
                time,
                room,
//                    grade
            )

            cursor.close()
        }
        database.close()
        return subject
    }

    fun showGrades(): MutableList<Subject>? {
        val query =
            "SELECT * from $TABLE_SUBJECTS"
        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var subs: MutableList<Subject>? = mutableListOf()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0).toInt()
                val surname = cursor.getString(1)
                val name = cursor.getString(2)
                val subject = cursor.getString(3)
                val typeSubject = cursor.getString(4)
                val dayOfWeek = cursor.getString(5)
                val time = cursor.getString(6)
                val room = cursor.getString(7)
                val grade = cursor.getString(8)?.toDouble()

                subs?.add(
                    Subject(
                        id,
                        surname,
                        name,
                        subject,
                        typeSubject,
                        dayOfWeek,
                        time,
                        room,
                        grade
                    )
                )
            } while (cursor.moveToNext())

            cursor.close()
        }
        db.close()
        return subs
    }

    fun deleteSubject(subject: String, typeSubject: String): Boolean {
        var result = false
        val query = "SELECT * from $TABLE_SUBJECTS WHERE $COLUMN_SUBJECT  = \"$subject\"" +
                "and $COLUMN_TYPESUBJECT  = \"$typeSubject\""
        val database = this.writableDatabase
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            val id = Integer.parseInt(cursor.getString(0))
            database.delete(TABLE_SUBJECTS, "$COLUMN_ID = ?", arrayOf(id.toString()))
            cursor.close()
            result = true
        }
        database.close()
        return result
    }

}