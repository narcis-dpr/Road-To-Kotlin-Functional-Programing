package com.narcis.monoids


fun List<Int>.sumList() = fold(0) {a,b -> a + b}

fun String.reversString() = foldRight("") {char, str -> str + char}


