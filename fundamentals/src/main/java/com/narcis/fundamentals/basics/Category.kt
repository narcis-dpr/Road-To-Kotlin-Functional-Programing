package com.narcis.fundamentals.basics

fun <A> identity(value: A) = value
/**
 * this code represents identity
 */


inline infix fun <A, B, C> Fun<B, C>.after(crossinline f: Fun<A, B>) :
        Fun<A, C> = {a: A ->
            this(f(a))
}
/**
 * this code represents gof(x)
 */

// usage :
fun main() {
    val f: Fun<Int, Int> = ::twice
    val g: Fun<Int, String> = ::format
    val formatTwice = g after f
    println(formatTwice(37))

    // associativity
    /**
     * ho(gof) = (hog)of
     */
    val h: Fun<String, Int> = ::length
    val leftSide = (h after g) after f
    val rightSide = h after (g after f)

    println(leftSide(37) == rightSide(37))

    /**
     * identity
     */

}

fun twice(a: Int): Int = a*2
fun format(b: Int): String = "Result is $b"

fun length(s: String): Int = s.length

fun half(a: Int): Int = a/2