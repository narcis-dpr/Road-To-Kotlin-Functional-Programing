package com.narcis.fundamentals

/**
 * Nothing is the initial object that any function being called with is has the same result
 */

fun <A> absurd(a: Nothing): A = a as A

/**
 * the function absurd cant be invoked since we need a Nothing for it
 */
fun main() {


}