package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.basics.after
import com.narcis.fundamentals.utiles.assertOrThrow

fun shiftLeft(x: Int) = x shl 1 // 1

fun not(x: Int) = x.inv()

val shiftLeftAndNot = ::not after ::shiftLeft
fun main() {
    val comp1 = not(shiftLeft(10))
    val comp2 = shiftLeftAndNot(10)
    assertOrThrow("comp1 != comp2") {
        comp1 == comp2
    }

}