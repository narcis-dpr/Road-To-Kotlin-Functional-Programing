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

// a + b = b + a
@Test
fun `test sum is commutative`(){
    100.times {
        val firstValue = Random.nextInt()
        val secondValue = Random.nextInt()
        val result1 = sum(firstValue, secondValue)
        val result2 = sum(secondValue, firstValue)
        Truth.assertThat(result1).isEqualTo(result2)
    }

    @Test
    fun `test addition is not multiplication`(){
        val randomValue = Random.nextInt()
        val result1 = sum(sum(randomValue, 1), 1)
        val result2 = sum(randomValue, 2)
        Truth.assertThat(result1).isEqualTo(result2)
    }

    @Test
    fun `test using unit value for addition`() {
        100.times {
            val randomValue = Random.nextInt()
            val result1 = sum(randomValue, 0)
            val expected = randomValue
            Truth.assertThat(result1).isEqualTo(expected)
        }
    }

}