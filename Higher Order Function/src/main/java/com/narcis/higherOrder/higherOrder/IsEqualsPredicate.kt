package com.narcis.higherOrder.higherOrder

fun <T> T.isEqualsPredicate(): (T) -> Boolean = { value ->
    this == value
}

fun main() {
    listOf(1, 2, 3, 4, 4, 5, 6, 7, 8, 8)
        .filter(4.isEqualsPredicate())
        .forEach(::println)
}