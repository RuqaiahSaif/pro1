package com.example1.myapplication

import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {
    val students = mutableListOf<Student>()
    init {
        for (i in 0 until 100) {
            val student = Student()
            student.name= "Crime #$i"
            student.pass = i % 2 == 0
            students += student
        }
    }

}