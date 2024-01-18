package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.basics.Fun
import kotlin.random.Random

fun twice(x: Int): Int = x*2 //pure

fun twiceAndLog(x: Int): Int { // not pure
    val result = x*2
    println("2 * $x = $result")
    return result
}

// not pure :
var count = 1
fun inc(x: Int): Int = ++count + x
// not pure :
fun randomInc(a: Int): Int = a + Random.nextInt()
// pure :
var count2 = 0
fun inc2(x: Int): Int = x + count2 + 1
// all pure :
fun negate(x: Int) = -x
fun identity(x: Int) = x
fun abs(x: Int) = if (x<0) negate(x) else identity(x) // compose from other pure functions
// not pure :
fun countedAbs(countIn: Int,x: Int): Pair<Int, Int>{
    return abs(x) to countIn+1
}
fun main() {
    var f: Fun<Int, Int> = ::twice
    println("Executing twice(10)")
    f(10)
    f = ::twiceAndLog
    println("Executing twiceAndLog(10")
    f(10)
}