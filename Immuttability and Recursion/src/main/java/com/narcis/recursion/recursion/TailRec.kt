package com.narcis.recursion.recursion

/*
instead of changing the value of a variable
in a cycle, you invoke a function, passing the new value as parameter
 */

fun imperativeFactorial(n: Int): Int {
    var result = 1
    for (value in 2..n) {
        result *= value
    }
    return result
}
fun recursiveFactorial(n: Int): Int = when(n) {
    1 -> 1
    else -> n * recursiveFactorial(n - 1)
}
fun recursiveFactorialWithFact(n: Int, fact: Int = 1): Int = when(n) {
    1 -> fact
    else -> n * recursiveFactorialWithFact(n - 1, n * fact)
}
fun main() {
    println(imperativeFactorial(10))
    println(recursiveFactorial(10))
}