package com.narcis.higherOrder.higherOrder

/**
this fun executes the fn lambda for the given times
the receiver is the Int value that we invoke times on
 */
fun Int.times(fn: (Int) -> Unit) = (1..this).forEach(fn)
// times without the forEach (which is a higher order fun in nature)

fun Int.times2(fn: (Int) -> Unit) {
    var i = 1
    while (i <= this) {
        fn(i++)
    }
}

fun main() {
    10.times {
        println(it)
    }
    10.times2 {
        println(it)
    }
}