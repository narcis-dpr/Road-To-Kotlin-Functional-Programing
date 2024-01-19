package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.utiles.assertOrThrow

fun main() {
    val expr1 = { 3 * 10 }
    val (a1, a2) = expr1() to expr1()
    val expr1Eval = expr1()
    val (a1Eval, a2Eval) = expr1Eval to expr1Eval
    assertOrThrow("expr1 is not RT") {  // evaluates here
        a1 == a1Eval && a2 == a2Eval
    }

}