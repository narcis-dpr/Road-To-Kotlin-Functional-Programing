package com.narcis.composition

fun pureFunction(x: Int) = x * x - 1 // referentially transparent expression

fun main() {
    pureFunction(5) pipe ::println
    pureFunction(5) pipe ::println
    pureFunction(5) pipe ::println


    functionWithEffect(5) pipe ::println
    functionWithEffect(5) pipe ::println
    functionWithEffect(5) pipe ::println
}
// adding side effect :
fun functionWithEffect(x: Int): Int { // returns the same result as pure function but with side effect
    val result = x * x - 1
    println("Result: $result")
    return result
}
