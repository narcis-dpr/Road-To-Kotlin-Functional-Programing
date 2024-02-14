package com.narcis.higherOrder.higherOrder

import com.narcis.higherOrder.imperativeVsDeclarative.EMAIL_REG_EX
import com.narcis.higherOrder.imperativeVsDeclarative.emails

fun interface Predicate1<T> {
    fun accept(value: T): Boolean
}

infix fun <T> Predicate1<T>.and(other: Predicate1<T>) = Predicate1<T> { value ->
    this.accept(value) && other.accept(value)
}

infix fun <T> Predicate1<T>.or(other: Predicate1<T>): Predicate1<T> =
    Predicate1 { value ->
        this.accept(value) || other.accept(value)
    }

fun <T> T.isEqualsPredicate1(): Predicate1<T> =
    Predicate1 { value -> this == value }

fun <T> Iterable<T>.filterWithPredicate(predicate: Predicate1<T>) =
    filter (predicate::accept)

fun main() {
    val predicate = 4.isEqualsPredicate1() or 5.isEqualsPredicate1()

    listOf(1,2,3,4,4,5,6,7,8,8)
        .filterWithPredicate(predicate)
        .forEach(::println)


    emails.filterWithPredicate(isValidEmail and isLongerThan(10))
        .take(5)
        .forEach(::println)
}

// exercis 5.5 :

val isValidEmail: Predicate1<String> =
    Predicate1 {value -> EMAIL_REG_EX.matches(value) }

fun isLongerThan(length: Int): Predicate1<String> =
    Predicate1 { value -> value.length > length }