package com.narcis.fundamentals.concepts

import com.narcis.fundamentals.utiles.invokeTimes
import org.junit.Assert.*
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class PureKtTest {
    @Test
    fun test100Times() {
        100.invokeTimes() {
            countedAbs(it)
        }
        assertEquals(count2, 100)
    }

    @Test
    fun test50Times() {
        50.invokeTimes() {
            countedAbs(it)
        }
        assertEquals(count2, 50)
    }
}

