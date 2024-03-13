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

typealias EitherBooleanOrNothing = Either<Boolean, Nothing>

val boolNothing1: Either<Boolean, Nothing> = Left(true)
val boolNothing2: Either<Boolean, Nothing> = Left(false)

typealias EitherBooleanOrUnit = Either<Boolean, Unit>

val boolUnit1: Either<Boolean, Unit> = Left(true)
val boolUnit2: Either<Boolean, Unit> = Left(false)
val boolUnit3: Either<Boolean, Unit> = Right(Unit)

fun main() {

}
