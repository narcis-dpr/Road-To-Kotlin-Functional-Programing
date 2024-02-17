package com.narcis.recursion.immutability

data class User( // this is an immutable class because every property is val
    val id: Int, // string and Int are also immutable
    val username: String
)