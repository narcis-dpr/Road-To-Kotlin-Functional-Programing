package com.narcis.expressionevaluationlaziness

/**
 * the eagerEvaluation is also Applicative Order
 */

fun greaterThan10(x: Int): Boolean {
    println("greaterThan10")
    return x > 10
}

fun main() {
    val inputValue = 3
    if (inputValue > 4 && greaterThan10(inputValue*2)) {
        println("OK")
    } else {
        println("KO")
    }
}