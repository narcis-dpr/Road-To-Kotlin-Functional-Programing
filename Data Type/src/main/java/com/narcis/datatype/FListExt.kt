package com.narcis.datatype

import java.lang.StringBuilder


tailrec fun <T, S> FList<T>.fold(
    start: S,
    combineFunc: (S, T) -> S
): S = when (this) {
    is Nil -> start
    is FCons<T> -> {
        tail.fold(combineFunc(start, head), combineFunc)
    }
}
fun <T, S> FList<T>.foldRight(
    start: S,
    combineFunc: (T, S) -> S
): S = when(this) {
    is Nil -> start
    is FCons<T> -> {
        combineFunc(head, tail.foldRight(start, combineFunc))
    }
}

fun <T> FList<T>.append(rhs: FList<T>): FList<T> =
    foldRight(rhs, {item, acc -> FCons(item, acc) })

fun <T, S> FList<T>.map(fn: Fun<T, S>): FList<S> =
    when(this) {
        is Nil -> FList.empty()
        is FCons<T> -> FCons(fn(head), tail.map(fn))
    }
fun main() {
    val numbers = FList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    numbers.fold(0) {acc, item -> acc + item} pipe ::println
    numbers.fold(1) {acc, item -> acc * item} pipe ::println

    FList.of(*("supercalifragilisticexpialidocious".toCharArray().toTypedArray()))
        .foldRight(StringBuilder()) {item, acc ->
            acc.append(item)
            acc
        } pipe ::println

    FList.of(1, 2, 3, 4, 5)
        .map(::double)
        .forEach(::println)

    val first = FList.of(1, 2, 3)
    val second = FList.of(4, 5, 6)

    first.append(second).forEach( ::println)


}