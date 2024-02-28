package com.example.ds


/*
matching patterns for comparing
 */
fun <T> FList<T>.size(): Int = match(
    whenNil = { 0 },
    whenCons = { head, tail -> 1 + tail.size() }
)

/*
null if the receiver is Nil, head if the receiver is FCons<T> :
 */
fun <T> FList<T>.head(): T? = match(
    whenNil = { null },
    whenCons = { head, tail -> head }
)

fun <T> FList<T>.tail(): FList<T>? = match(
    whenNil = { null },
    whenCons = { head, tail -> tail }
)

fun main() {
    println(FList.empty<Int>().size())
    println(FList.of(1).size())
    println(FList.of(1, 2, 3).size())

    println(FList.empty<Int>().head())
    println(FList.of(1).size())
    println(FList.of(1, 2, 3).size())
}