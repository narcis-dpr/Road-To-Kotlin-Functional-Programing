package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.basics.Fun
import java.io.Writer

/**
 * new version of pure functions in sideEffect
 */
//fun <A, B> Fun<A, B>.liftW(
//    log:(A, B) -> String
//): Writer<A, B> = { a: A ->
//    val b = this(a)
//    b to log(a, b)
//}