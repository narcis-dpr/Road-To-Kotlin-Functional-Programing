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

fun main() {
    val squareValue = {a: Int -> a *a }
    val formatError = {ex: Exception -> "Error ${ex.localizedMessage}"}
    strToIntEither("10").bimap(formatError, squareValue).getOrDefault(-1).pipe(::println)
    strToIntEither("10").bimap(formatError, squareValue).flip().getOrDefault("No Error!").pipe(::println)
    strToIntEither("10").rightMap(squareValue).getOrDefault(-1).pipe(::println)
    strToIntEither("10aaa").leftMap(formatError).getOrDefault("Generic Error").pipe(::println)

}