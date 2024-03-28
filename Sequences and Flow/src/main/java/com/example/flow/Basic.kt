package com.example.flow

import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

fun doSomeWork(name: String): Int = 10
suspend fun doSomeBgWork(ctx: CoroutineContext, name: String): Int = withContext(ctx) {
    doSomeWork(name)
}

fun main() {
    doSomeBgWork.curry()
}