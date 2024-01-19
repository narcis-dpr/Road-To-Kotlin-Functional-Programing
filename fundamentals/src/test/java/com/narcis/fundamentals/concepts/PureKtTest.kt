package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.utiles.invokeTimes
import org.junit.Assert.*
import org.junit.Test

class PureKtTest {
    @Test
    fun test100Times() {
        var c = 0
        100.invokeTimes() {
            val (count, _) = countedAbs(c, it)
            c = count
        }
        assertEquals(c, 100)
    }

    @Test
    fun test50Times() {
        var c = 0
        50.invokeTimes() {
            val (count, _) = countedAbs(c, it)
            c = count
        }
        assertEquals(c, 50)
    }
}

