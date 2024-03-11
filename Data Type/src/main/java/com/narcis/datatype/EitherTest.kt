package com.narcis.datatype

fun strToIntEither(str: String): Either<NumberFormatException, Int> = try {
    Either.right(str.toInt())
} catch(nfe: NumberFormatException) {
    Either.left(nfe)
}

fun <A, B, C, D> Either<A,B>.bimap(
    fl: (A) -> C,
    fr: (B) -> D
): Either<C, D> = when(this) {
    is Left<A> -> Either.left(fl(left))
    is Right<B> -> Either.right(fr(right))
}