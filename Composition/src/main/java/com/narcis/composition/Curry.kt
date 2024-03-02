package com.narcis.composition

fun main() {
    val double = { a: Int -> a * 2}
    val square = { a: Int -> a * a }
    val sum = { a: Int, b: Int -> a+b }
    val stringify = Int::toString // returns the string representation of the int input value

    // a practice of currying :
    val addThree = sum(3)
    val result = addThree(4)
    println(result)
}

fun sum(a: Int): (Int) -> Int = {b: Int -> a+b}