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