package com.narcis.expressionevaluationlaziness

fun e(): () -> Double {
    var currentSum = 1.0
    var n = 1
    return {
        currentSum += 1.0 / factorial(n++, 1).toDouble()
        currentSum
    }
}

tailrec fun factorial(n: Int, tmp: Int): Int =
    if (n == 1) tmp else factorial(n-1, n*tmp)
fun main() {
    val e = e()
    repeat(10) {
        println(e())
    }
}