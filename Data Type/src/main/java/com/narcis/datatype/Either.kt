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

// accessors :
fun <A, B> Either<A, B>.getOrDefault(
    defaultValue: B
): B = when(this) {
    is Left -> defaultValue
    is Right -> right
}
fun <A, B> Either<A, B>.getRightOrDefault(
    defaultValue: B
): B = when(this) {
    is Left -> defaultValue
    is Right -> right
}

fun <A, B> Either<A, B>.getLeftOrDefault(
    defaultValue: A
): A = when(this) {
    is Left<A> -> left
    is Right<B> -> defaultValue
}

fun <A, B> Either<A, B>.flip(): Either<B, A> = when(this) {
    is Left<A> -> Either.right(left)
    is Right<B> -> Either.left(right)
}