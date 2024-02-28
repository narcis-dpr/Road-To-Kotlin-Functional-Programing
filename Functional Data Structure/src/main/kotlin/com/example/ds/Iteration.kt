package com.example.ds

fun <T> FList<T>.forEach(fn: (T) -> Unit): Unit = match(
    whenNil = {},
    whenCons = { head, tail ->
        fn(head)
        tail.forEach(fn)
    }
)
fun <T> FList<T>.forEachIndexed(fn: (Int, T) -> Unit) {
    fun FList<T>.loop(i: Int = 0): Unit = match(
        whenNil = {},
        whenCons = {head, tail ->
            fn(i, head)
            tail.loop(i + 1)
        }
    )
}
fun main() {
    listOf(1, 2, 3).forEach {
        println(it)
    }
    FList.of(1, 2, 3).forEach {
        println(it)
    }
    FList.of("a", "b", "c").forEachIndexed {index, item ->
        println("$index $item")
    }
}