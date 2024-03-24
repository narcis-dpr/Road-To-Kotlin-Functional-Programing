package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.result

import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.example.fp.lib.Fun
import com.raywenderlich.fp.result.flatten

infix fun <A, B, C> Fun<A, Result<B>>.fish(
    g: Fun<B, Result<C>>
): (A) -> Result<C> = { a: A ->
    this(a).bind(g)
}

infix fun <B, C> Result<B>.bind(
    g: Fun<B, Result<C>>
): Result<C> = map(g).flatten()

fun <A> Result<Result<A>>.flatten(): Result<A> =
    if (isSuccess) {
        getOrNull()!!
    } else {
        Result.failure(exceptionOrNull()!!)
    }

fun <A> Result<A>.lift(value: A): Result<A> = Result.success(value)

fun <A, B> Result<A>.flatMap(fn: Fun<A, Result<B>>): Result<B> =
    map(::lift fish fn).flatten()