
package com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.example.fp.lib

/** Either<A, B> implementation */
sealed class Either<out A, out B> {

  companion object {
    @JvmStatic
    fun <A> left(left: A): Either<A, Nothing> = Left(left)

    @JvmStatic
    fun <B> right(right: B): Either<Nothing, B> = Right(right)
  }
}

data class Left<A>(val left: A) : Either<A, Nothing>()
data class Right<B>(val right: B) : Either<Nothing, B>()

/** This is a bimap function that receives two functions applying the one depending on the value */
fun <A, B, C, D> Either<A, B>.bimap(fl: (A) -> C, fr: (B) -> D): Either<C, D> = when (this) {
  is Left<A> -> Either.left(fl(left))
  is Right<B> -> Either.right(fr(right))
}

/** Apply the function to the left or do nothing */
fun <A, B, C> Either<A, B>.leftMap(fl: (A) -> C): Either<C, B> = when (this) {
  is Left<A> -> Either.left(fl(left))
  is Right<B> -> this
}

/** Apply the function to the left or do nothing */
fun <A, B, D> Either<A, B>.rightMap(fr: (B) -> D): Either<A, D> = when (this) {
  is Left<A> -> this
  is Right<B> -> Either.right(fr(right))
}

/** Accessor for the Right value */
fun <A, B> Either<A, B>.getOrDefault(defaultValue: B): B = when (this) {
  is Left<A> -> defaultValue
  is Right<B> -> right
}

/** Accessor for the Right value */
fun <A, B> Either<A, B>.getRightOrDefault(defaultValue: B): B = when (this) {
  is Left<A> -> defaultValue
  is Right<B> -> right
}

/** Accessor for the Left value */
fun <A, B> Either<A, B>.getLeftOrDefault(defaultValue: A): A = when (this) {
  is Left<A> -> left
  is Right<B> -> defaultValue
}

/** Flips the Either types */
fun <A, B> Either<A, B>.flip(): Either<B, A> = when (this) {
  is Left<A> -> Either.right(left)
  is Right<B> -> Either.left(right)
}


/** FlatMap implementation for Either<A, B> */
fun <A, B, D> Either<A, B>.flatMap(fn: (B) -> Either<A, D>): Either<A, D> = when (this) {
  is Left<A> -> Either.left(left)
  is Right<B> -> {
    val result = fn(right)
    when (result) {
      is Left<A> -> Either.left(result.left)
      is Right<D> -> Either.right(result.right)
    }
  }
}
