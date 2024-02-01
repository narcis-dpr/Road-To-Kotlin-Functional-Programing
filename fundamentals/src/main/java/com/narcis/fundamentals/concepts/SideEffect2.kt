package com.narcis.fundamentals.concepts

// we want to make former functions impure to have side effects and log the operations we
// are excepting in the funs

fun shiftLeftAndLog(x: Int): Int {
    println("shift left to $x")  // the print is a side effect
    return x shl 1
}

fun notAndLog(x: Int): Int {
    println("Negate $x")
    return x.inv()
}