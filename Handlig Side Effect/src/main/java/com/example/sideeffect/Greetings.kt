package com.example.sideeffect

import java.util.Scanner


val readName: (World) -> Pair<String, World> = { w: World ->
    Scanner(System.`in`).nextLine() to World
}

val printString: (String) -> SideEffect = { str: String ->
    { a: World ->
        print(str) to World
    }
}

fun main() {
    print("whats your name?")
    val name = Scanner(System.`in`).nextLine()
    print("Hello $name\n")
}