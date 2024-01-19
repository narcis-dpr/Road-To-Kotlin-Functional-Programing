package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.utiles.assertOrThrow

fun main() {
    // referential transparent: in every place that it used it can be replaced with final result!
    val expr1 = { 3 * 10 }
    val (a1, a2) = expr1() to expr1()
    val expr1Eval = expr1()
    val (a1Eval, a2Eval) = expr1Eval to expr1Eval
    assertOrThrow("expr1 is not RT") {  // evaluates here
        a1 == a1Eval && a2 == a2Eval
    }
    // referential opaque:
    /**
     * b1 is not equal to b1Eval meaning the reference of expr2 is not the same as expr2,
     * since the result depends on count and its not pure
     */
    var count =1
    val expr2 = {3 * 2 * ++count}
    val (b1, b2) = expr2() to expr2()
    val expr2Eval = expr2()
    val (b1Eval, b2Eval) = expr2Eval to expr2Eval
    assertOrThrow("expr2 is not RT") {
        b1 == b1Eval && b2 == b2Eval
    }
    // are this the same? :
    val expr3 = { 42 }
    val (a3, a4) = expr3() to expr3()
    val expr3Eval = expr3()
    val (a3Eval, a4Eval) = expr3Eval to expr3Eval
    assertOrThrow("expr2 is not RT") {
        a3 == a3Eval && a4 == a4Eval
    }
    // yes
    //impure function with referential transparency:
    val expr4 = { println("Hello Wrold!") }
    val (c1, c2) = expr4() to expr4()
    val expr4Eval = expr4()
    val (c1Eval, c2Eval) = expr4Eval to expr4Eval
    assertOrThrow("expr2 is not RT") {
        c1 == c1Eval && c2 == c2Eval
    }
}