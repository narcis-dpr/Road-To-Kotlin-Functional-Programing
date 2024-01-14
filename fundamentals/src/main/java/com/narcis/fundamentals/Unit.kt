package com.narcis.fundamentals

/**
 * a terminal object is a type output of a unique function accepting an input
 * parameter of any other type, including Nothing --> Unit in kotlin
 */
fun <A> unit(a: A): Unit = Unit
/**
 * for any type A you can create this function, for any type A the function is unique,
 * Unit isnt just a type, its also the only value of that type
 */

// discovering the uniqueness of unit :
fun <A> unit2(a: A): Unit {
    println("im different")
    return Unit
}
/**
 * unit and unit2 are the same
 */
