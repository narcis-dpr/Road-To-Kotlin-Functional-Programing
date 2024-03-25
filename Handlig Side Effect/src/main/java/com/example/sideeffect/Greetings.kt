package com.example.sideeffect

import java.util.Scanner


val readName: (World) -> Pair<String, World> = { w: World ->
    Scanner(System.`in`).nextLine() to World
}

/**
 * printString doesnt execute a side effect but returns a description of it ! :
 */
val printString: (String) -> SideEffect = { str: String ->
    { a: World ->
        print(str) to World
    }
}

fun askNameAndPrintGreetings(): (World) -> World = {w0: World ->
    val w1 = printString("whats your name? ")(w0) // w1 is the new state of the world
    val (name, w2) = readName(w1)
    printString("Hello $name! \n")(w2)
}
fun main() {
    print("whats your name?")
    val name = Scanner(System.`in`).nextLine()
    print("Hello $name\n")

    readName(World) pipe ::println
    printString("Hello Narcis \n")(World) pipe ::println

    // this way of composing functions is called monad comprehension :
    askNameAndPrintGreetings()(World) pipe ::println
}