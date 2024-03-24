package com.example.errorhandling.tVApp.app.src.main.java.com.example.android.result

import com.example.errorhandling.tVApp.libs.fp.src.main.kotlin.com.raywenderlich.fp.lib.Fun

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