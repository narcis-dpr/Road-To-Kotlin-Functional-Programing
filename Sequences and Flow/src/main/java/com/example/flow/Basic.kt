package com.example.flow

import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

fun doSomeWork(name: String): Int = 10
suspend fun doSomeBgWork(ctx: CoroutineContext, name: String): Int = withContext(ctx) {
    doSomeWork(name)
}

fun main() {
    ::doSomeBgWork.curry()
}

typealias SuspendFun<A, B> = suspend (A) -> B
typealias SuspendFun2<A, B, C> = suspend (A, B) -> C
typealias SuspendChain2<A, B, C> = suspend (A) -> suspend (B) -> C

fun <A, B, C> SuspendFun2<A, B, C>.curry(): SuspendChain2<A, B, C> = {a: A ->
    {b: B ->
        this(a, b)
    }
}