package com.narcis.higherOrder.higherOrder

inline fun executor(fn: () -> Unit) {fn()}
fun main() {
    executor { println("Hello World!") }
}