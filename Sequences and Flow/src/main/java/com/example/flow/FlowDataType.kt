package com.example.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import java.util.Scanner

fun inputStringFlow(question: String = "") = flow {
    val scanner = Scanner(System.`in`)
    print(question)
    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        if (line.isNullOrEmpty()) {
            break
        }
        emit(line)
        println(question)
    }
    scanner.close()
}

fun <A, B> Flow<A>.ap(fn: Flow<(A) -> B>): Flow<B> = flow {
    collect { a ->
        fn.collect { f ->
            emit(f(a))
        }
    }
}

infix fun <A, B> Flow<(A) -> B>.appl(
    a: Flow<A>
) = a.ap(this)

fun main() {
    val strLengthFlow = inputStringFlow("Insert a word: ").map { str -> str to str.length }

    runBlocking {
        strLengthFlow.collect { strInfo ->
            println("${strInfo.first} has length ${strInfo.second}")
        }
    }
}