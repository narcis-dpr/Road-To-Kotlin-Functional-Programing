package com.narcis.recursion.immutability.benefits

data class Key(
    val id: Int
)
fun main() {
    val key1 = Key(1)
    val key2 = Key(1)
    val myMap = mutableMapOf<Key, String>()
    myMap[key1] = "First"
    println("Value for $key1 is ${myMap[key1]}")
    println("The Map is $myMap")
    myMap[key2] = "Second"
    println("Value for $key2 is ${myMap[key2]}")
    println("The Map is $myMap")
}