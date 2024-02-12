package com.narcis.higherOrder.higherOrder

typealias SinglePredicate<T> = (T) -> Boolean

fun <T> SinglePredicate<T>.whoAmI() = println("Im a typealias")

fun main() {
    val isEven = {number : Int -> number % 2 == 0}
    isEven.whoAmI()
}