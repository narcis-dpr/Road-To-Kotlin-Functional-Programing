package com.narcis.monoids

import com.google.common.truth.Truth
import org.junit.Test
import kotlin.random.Random

// property testing :
@Test
fun `sum test using random values 100 times`() {
    100.times {
        val firstValue = Random.nextInt()
        val secondValue = Random.nextInt()
        val expectedValue = firstValue + secondValue
        Truth.assertThat(sum(firstValue, secondValue)).isEqualTo(expectedValue)

    }
}