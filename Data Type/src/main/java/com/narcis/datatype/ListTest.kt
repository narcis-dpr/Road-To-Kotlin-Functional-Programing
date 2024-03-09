package com.narcis.datatype


fun countUpTo(value: Int) = List(value) { it }

fun main() {
    val emptyList = emptyList<Int>()
    val intList = listOf(1, 2, 3)
    intList.map(::double).forEach(::println) // map returns a list that are double of the values
    println("---")
    intList.flatMap(::countUpTo).forEach(::println) // flat map returns a list of list flatten into on list
}