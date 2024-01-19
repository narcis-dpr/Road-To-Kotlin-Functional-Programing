package com.narcis.fundamentals.concepts

import kotlin.math.sqrt

fun square(x: Double): Double = x * x
fun root(x: Double): Double = sqrt(x)

fun distance(
    x0: Double,
    x1: Double,
    y0: Double,
    y1: Double
): Double {
    val s1 = square(x1 - x0)
    val s2 = square(y1 - y0)

    return root(s1 + s2)
}
// all of three functions above are pure
fun main() {

}

