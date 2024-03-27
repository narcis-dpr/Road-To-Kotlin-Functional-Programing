@file:JvmName("PropertyTest")

package com.raywenderlich.fp.lib

import kotlin.random.Random

/** Abstraction for the generation of random values */
fun interface Generator<T> {
  fun generate(n: Int): List<T>
}

/** Generator implementation for Int */
object IntGenerator : Generator<Int> {
  override fun generate(n: Int): List<Int> = List(n) { Random.nextInt() }
}

/** Generator implementation for Long */
object LongGenerator : Generator<Long> {
  override fun generate(n: Int): List<Long> = List(n) { Random.nextLong() }
}

/** Utility that returns a simple value */
fun <T> Generator<T>.one(): T = generate(1)[0]

/** Generator implementation for String */
class StringGenerator(
  private val minLength: Int = 0, private val maxLength: Int = 10
) : Generator<String> {
  val chars =
    "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "1234567890!±§!@£$%^&*()_+-="

  override fun generate(n: Int): List<String> = List(n) {
    val length = Random.nextInt(minLength, maxLength)
    val currentString = StringBuilder()
    (1..length).forEach {
      currentString.append(chars[Random.nextInt(0, chars.length)])
    }
    currentString.toString()
  }
}

/** Abstraction of a generic property */
interface Property<T> {
  operator fun invoke(
    gen: Generator<T>, fn: (List<T>) -> T
  ): Boolean
}

/** Both must be true */
infix fun <T> Property<T>.and(rightProp: Property<T>): Property<T> = object : Property<T> {
  override fun invoke(gen: Generator<T>, fn: (List<T>) -> T): Boolean =
    this@and(gen, fn) && rightProp(gen, fn)
}
