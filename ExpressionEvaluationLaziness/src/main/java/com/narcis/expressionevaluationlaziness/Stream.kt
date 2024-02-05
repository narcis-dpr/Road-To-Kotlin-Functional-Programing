package com.narcis.expressionevaluationlaziness

/**
 * create a lzy stream with kotlin
 */

fun eagerEvenSequence(n: Int): List<Int> = List(n) { i -> i * 2 }

fun evenPositiveStream(): () -> Int { // provides an even Int value every time you invoke it
    var count = -2
    return {count +=2; count} // returns a function of type () -> Int
}

fun main() {
    println(eagerEvenSequence(5))
    val evenSequence = evenPositiveStream()
    repeat(5) {
        println(evenSequence())
    }
}