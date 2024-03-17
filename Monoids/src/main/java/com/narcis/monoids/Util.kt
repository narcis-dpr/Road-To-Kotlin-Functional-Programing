package com.narcis.monoids

fun Int.times(fn: (Int) -> Unit) = (1..this).forEach(fn)