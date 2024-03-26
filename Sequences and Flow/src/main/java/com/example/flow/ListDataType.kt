package com.example.flow

fun main() {
    listOf(1, 2, 3, 4, 5)
        .filter(filterOdd.logged("filterOdd"))
        .map(double.logged("double"))
}