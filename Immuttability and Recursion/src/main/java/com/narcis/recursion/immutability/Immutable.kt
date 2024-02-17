package com.narcis.recursion.immutability

import java.util.Date

data class User( // this is an immutable class because every property is val
    val id: Int, // string and Int are also immutable
    val username: String
)

data class WrongImmutableUser(
    val id: Int,
    val username: String,
    val dob: java.util.Date = Date() // because of this the class isn't fully immutable
)

fun main() {
    val w = WrongImmutableUser(1, "maxcarli")
    println(w)
    w.dob.time = 1000L // access dob and changing it
    println(w)
}