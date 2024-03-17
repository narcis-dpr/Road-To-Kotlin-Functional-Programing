package com.narcis.monoids

import android.content.pm.PackageManager.Property
import com.google.common.truth.Truth
import org.junit.Test
import kotlin.random.Random

fun sum(a: Int, b: Int): Int = a + b

fun interface Generator<T> {
    fun generator(n: Int): List<T>
}

object IntGenerator: Generator<Int> {
    override fun generator(n: Int) = List(n) {
        Random.nextInt()
    }

}

class PropertyTest {
    @Test
    fun sum_test_using_predefined_values() {
        Truth.assertThat(sum(2,3)).isEqualTo(5)
        Truth.assertThat(sum(2, 5)).isEqualTo(7)
        Truth.assertThat(sum(-2, 5)).isEqualTo(3)
    }

    @Test
    fun sum_test_using_random_values() {
        val firstValue = Random.nextInt()
        val secondValue = Random.nextInt()
        val expectedValue = firstValue + secondValue
        Truth.assertThat(sum(firstValue, secondValue)).isEqualTo(expectedValue)
    }
}