package com.narcis.recursion.immutability
data class MutableKey(
    val id: Int // if its var makes the class inconsistent
)

fun main() {
    val key1 = MutableKey(1)
    val key2 = MutableKey(2)

    val myMap = mutableMapOf(
        key1 to "First",
        key2 to "Second"
    )
    println("Value for $key2 is ${myMap[key2]}")
    println("The Map is $myMap")
    myMap.remove(key1).also { println("Removed $key1 from myMap") }
    myMap.remove(key2).also { println("Remove $key2 from myMap") }

    println("The Map after remove is $myMap")
    println("Value for $key1 is ${myMap[key1]} after key1 remove")
    println("Value for $key2 is ${myMap[key2]} after key2 remove")
}