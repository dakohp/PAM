package com.example.aplikacjazaliczeniowa

class Subject {
    var id: Int = 0
    var name: String? = null
    var surname: String? = null
    var subject: String? = null
    var typeSubject: String? = null
    var dayOfWeek: String? = null
    var time: String? = null
    var room: String? = null
    var grade: Double? = 0.0

    constructor(
        id: Int,
        name: String,
        surname: String,
        subject: String,
        typeSubject: String,
        dayOfWeek: String,
        time: String,
        room: String,
        grade: Double?,
    ) {
        this.id = id
        this.name = name
        this.surname = surname
        this.subject = subject
        this.typeSubject = typeSubject
        this.dayOfWeek = dayOfWeek
        this.time = time
        this.room = room
        this.grade = grade
    }

    constructor(
        id: Int,
        name: String,
        surname: String,
        subject: String,
        typeSubject: String,
        dayOfWeek: String,
        time: String,
        room: String

    ) {
        this.id = id
        this.name = name
        this.surname = surname
        this.subject = subject
        this.typeSubject = typeSubject
        this.dayOfWeek = dayOfWeek
        this.time = time
        this.room = room
    }

    constructor(
        name: String,
        surname: String,
        subject: String,
        typeSubject: String,
        dayOfWeek: String,
        time: String,
        room: String,
        grade: Double
    ) {
        this.name = name
        this.surname = surname
        this.subject = subject
        this.typeSubject = typeSubject
        this.dayOfWeek = dayOfWeek
        this.time = time
        this.room = room
        this.grade = grade
    }

    constructor(
        name: String,
        surname: String,
        subject: String,
        typeSubject: String,
        dayOfWeek: String,
        time: String,
        room: String,
    ) {
        this.name = name
        this.surname = surname
        this.subject = subject
        this.typeSubject = typeSubject
        this.dayOfWeek = dayOfWeek
        this.time = time
        this.room = room
    }

    constructor()
}
