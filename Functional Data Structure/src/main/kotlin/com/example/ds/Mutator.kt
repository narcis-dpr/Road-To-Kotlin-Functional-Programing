package com.example.ds

fun <T> FList<T>.append(newItem: T): FList<T> = match(
    whenNil = { FList.of(newItem) },
    whenCons = { head, tail ->
        FList.FCons(head, tail.append(newItem))
    }
)

fun main() {
    val initialList = FList.of(1, 2)
    val addedList = initialList.append(3)
    initialList.forEach {
        print("$it ")
    }
    println()
    addedList.forEach {
        print("$it ")
    }
}