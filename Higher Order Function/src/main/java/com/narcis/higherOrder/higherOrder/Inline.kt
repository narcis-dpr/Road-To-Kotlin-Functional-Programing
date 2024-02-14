package com.narcis.higherOrder.higherOrder

inline fun executor(fn: () -> Unit) {fn()}
fun main() {
    executor { println("Hello World!") }

    executor {
        var count = 0
        while (true) {
            count++
            if (count > 5) {
                return  // if you dont inline executor, the compiler complains about not knowing
                        // from what context it should actually return
            }
        }
    }
    println("The End!")
}