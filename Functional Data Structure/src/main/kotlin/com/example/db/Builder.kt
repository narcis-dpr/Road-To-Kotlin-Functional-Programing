package com.example.db

/*
the use of the spread operator * which allows you to use the values in an
array as if they were a list of multiple vararg input parameter
 */
fun <T> fListOf(vararg items: T): FList<T> { // vararg for value of type T
    val tail = items.sliceArray(1 until items.size)
    return if (items.isEmpty()) FList.Nil else FList.FCons(items[0], fListOf(*tail))
}

fun main() {
    val emptyList = FList.empty<Int>()
    val singleElementList = FList.of(1)
    val singleElementList2 = FList.FCons(1, emptyList)
    val twoElementsList = FList.of(1, 2)
}