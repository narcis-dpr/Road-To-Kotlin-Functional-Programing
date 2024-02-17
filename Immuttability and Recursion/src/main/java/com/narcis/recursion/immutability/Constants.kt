package com.narcis.recursion.immutability

fun main() {
    val constantUser = MutableUser(1, "Max")
     //Error :  constantUser = MutableUser(2, "Alice") // cant change the value
    constantUser.username = "Alice" // but we can change the state
}

fun changeUsername(user: MutableUser) {
   // ERROR: user = MutableUser(2, "Alice")
    user.username = "Alice"
}