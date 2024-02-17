package com.narcis.recursion.immutability

fun main() {
    val immutableList = listOf(1, 2, 3, 4, 5)
    val asMutableList = immutableList as MutableList<Int>
    asMutableList.add(10) // throws exception
}