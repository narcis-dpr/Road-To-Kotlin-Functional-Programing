package com.example.db

data class Node<T>(
    val value: T,
    val next: Node<T>? = null
)

fun main() {
    val emptyList: Node<*>? = null
    val singleValueList = Node(1)
}