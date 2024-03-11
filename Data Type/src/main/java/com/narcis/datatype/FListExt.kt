package com.narcis.datatype


tailrec fun <T, S> FList<T>.fold(
    start: S,
    combineFunc: (S, T) -> S
): S = when (this) {
    is Nil -> start
    is FCons<T> -> {
        tail.fold(combineFunc(start, head), combineFunc)
    }
}

fun main() {
    val numbers = FList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    numbers.fold(0) {acc, item -> acc + item} pipe ::println
    numbers.fold(1) {acc, item -> acc * item} pipe ::println
}