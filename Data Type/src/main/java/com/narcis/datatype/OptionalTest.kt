package com.narcis.datatype

import java.lang.NumberFormatException

fun strToInt(value: String): Optional<Int> = // since this operation can fail, the neuter type is an optional<Int>
    try {
        Optional.lift(value.toInt())
    } catch (nfe: NumberFormatException) {
        Optional.empty()
    }

fun double(value: Int): Int = value * 2

fun main() {
    val res = strToInt("10")
    when(res) {
        is Some<Int> -> {
            val res2 = double(res.value)
            println("Result is $res2")
        }
        is None -> println("Error!")
    }

    // test error :
    val resE = strToInt("100aaa")
}