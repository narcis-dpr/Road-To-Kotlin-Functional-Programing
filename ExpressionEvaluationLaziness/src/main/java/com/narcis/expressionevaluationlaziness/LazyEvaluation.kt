package com.narcis.expressionevaluationlaziness

fun main() {
    val inputValue = 3
    val greater10 = { greaterThan10(inputValue) } // make it lambda to evaluate lazily
    if (inputValue > 4 && greater10()) {
        println("Ok")
    } else {
        println("Ko")
    }
}