package com.narcis.datatype

/*
the use of sealed class Either<A,B> is that it can only be Left<A> or Right<B>
 */
sealed class Either<out A, out B> {
    companion object {
        @JvmStatic
        fun <A> left(left: A): Either<A, Nothing> = Left(left)

        @JvmStatic
        fun <B> right(right: B): Either<Nothing, B> = Right(right)
    }
}

data class Left<A>(val left: A): Either<A, Nothing>()
data class Right<B>(val right: B): Either<Nothing, B>()

fun <A, B, C> Either<A, B>.leftMap(
    fl: (A) -> C
): Either<C, B> = when(this) {
    is Left<A> -> Either.left(fl(left))
    is Right<B> -> this // return the receiver itself
}

fun <A, B, D> Either<A, B>.rightMap(
    fr: (B) -> D
): Either<A, D> = when(this) {
    is Right<B> -> Either.right(fr(right))
    is Left<A> -> this
}