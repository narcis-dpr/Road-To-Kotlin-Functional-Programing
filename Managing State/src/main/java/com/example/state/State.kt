package com.example.state

typealias StateTransformer<S, T> = (S) -> Pair<S, T>
val skuStateTransformer: StateTransformer<Int, String> = {state ->  state + 1 to "RAY-PROD-${String.format("%04d", state)}" }

fun main() {
    val prod1 = Product("1", "cheese")
    val prod2 = Product("2", "Bread")
    val prod3 = Product("3", "Cake")

    val state0 = 0
    val (state1, sku1) = skuStateTransformer(state0)
    SkuProduct(prod1, sku1) pipe ::println
    val (state2, sku2) = skuStateTransformer(state1)
    SkuProduct(prod2, sku2) pipe ::println
    val (state3, sku3) = skuStateTransformer(state2)
    SkuProduct(prod2, sku2) pipe ::println

}