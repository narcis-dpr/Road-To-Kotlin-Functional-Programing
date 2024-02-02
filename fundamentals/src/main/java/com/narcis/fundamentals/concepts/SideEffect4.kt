package com.narcis.fundamentals.concepts

import java.io.Writer


/*
the testable impure function that are also composable
 */

fun shiftLeftWithEffect(x: Int): Pair<Int, String> {
    return x shl 1 to "shift left of $x"
}
fun noWithEffect(x: Int): Pair<Int, String> {
    return x.inv() to "Negate $x"
}
//infix fun <A, B, C> Writer<B, C>.after(
//    w: Writer<A, B>
//): Writer<A, C> = {a: A ->
//    val (b, str) = w(a)
//    val (c, str2) = this(b)
//    c to "$str \n $str2 \n"
//
//}