package com.narcis.monoids

import com.google.common.truth.Truth
import org.junit.Test

fun sum(a: Int, b: Int): Int = a + b

class PropertyTest {
    @Test
    fun sum_test_using_predefined_values() {
        Truth.assertThat(sum(2,3)).isEqualTo(5)
        Truth.assertThat(sum(2, 5)).isEqualTo(7)
        Truth.assertThat(sum(-2, 5)).isEqualTo(3)
    }
}