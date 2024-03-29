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

data class WrongImmutableUserWithDefensiveCopy(
    val id: Int,
    val username: String,
    val _dob: Date = Date()
) {
    val dob: Date  // read-only property
        get() = Date().apply {
            time = _dob.time // create a copy of _dob every time the same property is accessed
        }
}

data class MutableUser(
    val id: Int,
    var username: String  // one var in enough for make this class mutable
)

fun main() {
    val w = WrongImmutableUser(1, "maxcarli")
    println(w)
    w.dob.time = 1000L // access dob and changing it
    println(w)

    val w1 = WrongImmutableUserWithDefensiveCopy(1, "maxcarli")
    println(w1)
    w1.dob.time = 1000L // access dob and changing it but it wont change because its a copy
    println(w1)
    /// mutable class :
    val mutableUser = MutableUser(8, "maxcarli")
    println(mutableUser)
    mutableUser.username = "massimo"
    println(mutableUser)
}