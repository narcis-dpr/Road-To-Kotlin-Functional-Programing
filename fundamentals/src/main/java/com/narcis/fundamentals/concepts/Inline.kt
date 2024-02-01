package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.utiles.assertOrThrow

fun cube(x: Int): Int = x * x * x

fun doubleCube(x: Int) = cube(x) + cube(x) // since this fun is referentially transparent you
                                            // you can replace doubleCube(2) with 16 every time

fun main() {
    assertOrThrow("") {
        doubleCube(2) == 16
    }
}