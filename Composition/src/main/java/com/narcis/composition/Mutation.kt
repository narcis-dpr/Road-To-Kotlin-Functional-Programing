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
// the process of purifying :
typealias Updater<T> = (T) -> T // the abstraction of any function that maps objects in another object of the same type

fun squareWithEffect(x: Int): Pair<Int, Updater<MutableCounter>> {
    val result = x * x
    return result to { counter -> counter.count *= 10; counter}
}

fun doubleWithEffect(x: Int): Pair<Int, Updater<MutableCounter>> {
    val result = x * 2
    return result to { counter -> counter.count /2; counter}
}