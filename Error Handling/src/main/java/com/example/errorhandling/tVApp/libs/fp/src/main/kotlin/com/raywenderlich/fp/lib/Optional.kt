
package com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib

/** Optional type */
sealed class Optional<out T> {

  companion object {
    @JvmStatic
    fun <T> lift(value: T): Optional<T> = Some(value)

    @JvmStatic
    fun <T> empty(): Optional<T> = None
  }
}

object None : Optional<Nothing>()
data class Some<T>(val value: T) : Optional<T>()

/** The map function for Optional<T> */
fun <A, B> Optional<A>.map(fn: Fun<A, B>): Optional<B> = when (this) {
  is None -> Optional.empty()
  is Some<A> -> Optional.lift(fn(value))
}

/** The flatMap function for Optional<T> */
fun <A, B> Optional<A>.flatMap(fn: Fun<A, Optional<B>>): Optional<B> = when (this) {
  is None -> Optional.empty()
  is Some<A> -> {
    val res = fn(value)
    when (res) {
      is None -> Optional.empty()
      is Some<B> -> Optional.lift(res.value)
    }
  }
}

/** Extract the value in the Optional if any */
fun <A> Optional<A>.getOrDefault(defaultValue: A): A = when (this) {
  is None -> defaultValue
  is Some<A> -> value
}
