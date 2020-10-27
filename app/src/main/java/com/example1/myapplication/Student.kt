package com.example1.myapplication

import java.util.*

data class Student(
     val id: UUID = UUID.randomUUID(),
     var name: String = "",
     var pass: Boolean = true
){
}