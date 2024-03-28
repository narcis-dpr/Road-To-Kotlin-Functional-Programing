package com.example.flow

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

fun main() {
    val strLengthFlow = inputStringFlow("Insert a word: ").map { str -> str to str.length }

    runBlocking {
        strLengthFlow.collect {strInfo ->
            println("${strInfo.first} has length ${strInfo.second}")
        }
    }
}