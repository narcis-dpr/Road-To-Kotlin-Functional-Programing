package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.basics.Fun

fun twice(x: Int): Int = x*2

fun twiceAndLog(x: Int): Int {
    val result = x*2
    println("2 * $x = $result")
    return result
}

fun main() {
    var f: Fun<Int, Int> = ::twice
    println("Executing twice(10)")
    f(10)
    f = ::twiceAndLog
    println("Executing twiceAndLog(10")
    f(10)
}