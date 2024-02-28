package com.example.ds


/*
matching patterns for comparing
 */
fun <T> FList<T>.size(): Int = match(
    whenNil = { 0 },
    whenCons = {head, tail -> 1 + tail.size() }
)
fun main() {
    println(FList.empty<Int>().size())
    println(FList.of(1).size())
    println(FList.of(1, 2, 3).size())
}