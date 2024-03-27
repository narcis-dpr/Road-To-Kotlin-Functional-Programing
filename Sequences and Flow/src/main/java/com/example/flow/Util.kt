package com.example.flow

fun Int.times(fn: (Int) -> Unit) = (1..this).forEach(fn)

fun <A, B> ((A) -> B).logged(str: String): (A) -> B = {
  val result = this(it)
  println("$str($it) = $result ")
  result
}

val double = { a: Int -> 2 * a }

val filterOdd = { a: Int -> a % 2 == 0 }

fun interface Generator<T> {
  fun generate(n: Int): List<T>
}