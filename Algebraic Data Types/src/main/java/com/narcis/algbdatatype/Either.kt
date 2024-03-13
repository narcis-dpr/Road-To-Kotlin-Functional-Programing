package com.narcis.algbdatatype

sealed class Either<out A, out B>
data class Left<A>(val left: A): Either<A, Nothing>()
data class Right<B>(val right: B): Either<Nothing, B>()

typealias EitherBooleanOrBoolean = Either<Boolean, Boolean>

// all possible values :
val either1 = Left(true)
val either2 = Left(false)
val either3 = Right(true)
val either4 = Right(false)

typealias EitherBooleanOrTriage = Either<Boolean, Triage>

val eitherTriage1: Either<Boolean, Triage> = Left(true)
val eitherTriage2: Either<Boolean, Triage> = Left(false)
val eitherTriage3: Either<Boolean, Triage> = Right(Triage.RED)
val eitherTriage4: Either<Boolean, Triage> = Right(Triage.YELLOW)
val eitherTriage5: Either<Boolean, Triage> = Right(Triage.GREEN)

fun main() {

}
