package com.narcis.composition

data class MutableCounter(
var count: Int = 1
)

val counter = MutableCounter()

fun squareWithMutationEffect(x: Int): Int {
    val result = x * x
    counter.count *= 10
    return  result
}

fun doubleWithMutationEffect(x: Int): Int {
    val result = x * 2
    counter.count /= 2
    return result
}