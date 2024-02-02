package com.narcis.expressionevaluationlaziness

fun add(x: Int, y: Int): Int {
    val result = x + y
    println("add")  // add print to pure function to get how and when they are evaluated
    return result
}

fun triple(x: Int): Int {
    val result = add(add(x,x), x)
    println("triple")
    return result
}

fun divide(x: Int, y: Int): Int {
    val result = x/y
    println("divide")
    return result
}
fun average(x: Int, y:Int) : Int{
    val result = divide(add(x,y), 2)
    println("average")
    return result
}
fun main() {
    triple(average(2, 4)) // see the order of evaluation in here
    val result = triple(average(2, 4))
    println(result)
}