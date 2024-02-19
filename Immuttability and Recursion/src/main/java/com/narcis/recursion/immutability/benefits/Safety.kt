package com.narcis.recursion.immutability.benefits

import kotlin.concurrent.thread
import kotlin.random.Random

// race condition creation :
data class MutableCounter(
    var count: Int = 0
)

val counter = MutableCounter()

val task = {
    randomDelay()
    counter.count++
    randomDelay()
    if (counter.count == 2) {
        println("Completed")
    }
}

// resolve race condition :
data class Counter (
    val count: Int = 0
)
fun incAndCheck(counter: Counter): Counter {
    randomDelay()
    val newCounter = Counter(counter.count + 1)
    randomDelay()
    if (newCounter.count == 2) {
        println("Completed")
    }
    return newCounter
}
fun main() {
    // creating a race condition :
    thread (block = task)
    thread(block = task)
    // resolve race condition :
    val counter = Counter()
    var counter1: Counter ?= null
    val th1 = thread {
        counter1 = incAndCheck(counter)
    }
    th1.join()
    thread {
        incAndCheck(counter1 ?: Counter(0))
    }
}
fun randomDelay(max: Long = 100) =
    Thread.sleep(Random.nextLong(0, max))