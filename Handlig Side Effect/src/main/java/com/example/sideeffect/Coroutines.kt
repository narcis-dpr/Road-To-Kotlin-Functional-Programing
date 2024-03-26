package com.example.sideeffect

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.runBlocking
import java.util.Scanner

suspend fun readStringCo(): String = Scanner(System.`in`).nextLine()

suspend fun printStringCo(str: String) = print(str)

@DelicateCoroutinesApi
fun main() {
    runBlocking {
        printStringCo("whats your name? ")
      //  val name: async {}
        printStringCo("Hello $ name! \n")
    }
}