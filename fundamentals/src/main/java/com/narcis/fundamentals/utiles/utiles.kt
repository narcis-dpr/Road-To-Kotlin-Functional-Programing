package com.narcis.fundamentals.utiles
fun Int.invokeTimes(f: (Int) -> Unit) = (1..this).forEach(f)