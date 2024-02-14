package com.narcis.higherOrder.higherOrder

/**
 * returning a lambda expression as an output value
 */


fun countFrom(start: Int): () -> Int {
    var count = start
    return {
        count++
    }
}

fun main() {
    val countFromFive = countFrom(5)

    println(countFromFive())
    println(countFromFive())
    println(countFromFive())
}