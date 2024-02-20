package com.narcis.recursion.immutability

import com.narcis.recursion.immutability.benefits.MutableCounter
import com.narcis.recursion.immutability.benefits.randomDelay
import kotlin.concurrent.thread

/*
a critical section is a black of code that only one thread
can access at a time
 */

@Synchronized // this annotation makes the body of the function a critical section, this annotation
// means that only one thread at a time can access this block
fun syncedMutableIncAndCheck(counter: MutableCounter) {
    randomDelay()
    counter.count++
    randomDelay()
    if (counter.count == 2) {
        println("Completed")
    }
}
fun main() {
    val counter = MutableCounter()
    thread {
        syncedMutableIncAndCheck(counter)
    }
    thread {
        syncedMutableIncAndCheck(counter)
    }
}