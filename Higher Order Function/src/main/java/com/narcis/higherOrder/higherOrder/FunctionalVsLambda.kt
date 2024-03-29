package com.narcis.higherOrder.higherOrder

typealias SinglePredicate<T> = (T) -> Boolean

fun <T> SinglePredicate<T>.whoAmI() = println("Im a typealias")


fun interface ISinglePredicate<T> {
    fun accept(value: T): Boolean // single abstract method (SAM)

    fun other() {
        println(" I can have other methods")
    }
}
fun <T> ISinglePredicate<T>.whoAmI() =
    println("Im a functional interface")
fun main() {
    val isEven = {number : Int -> number % 2 == 0}
    isEven.whoAmI()

    val isEvenFI = ISinglePredicate<Int> {number -> number%2 == 0}

    isEvenFI.whoAmI()
    isEvenFI.other()
}