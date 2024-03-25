package com.example.state

// we want to assign a SKU to this data class aka: stock keeping unit (which is a scannable barcode)
data class Product(val id: String, val name: String)
data class SkuProduct(val product: Product, val sku: String)

var count = 0
fun createSku(): String = "RAY-PROD-${String.format("%04d", count++)}"

val assignSku: (Product, Int) -> Pair<SkuProduct, Int> = {product: Product, state ->
    val newSku = "RAY-PROD-${String.format("%04d", state)}"
    SkuProduct(product, newSku) to state + 1
}
val curriedAssignedSku: (Product) -> (Int) -> Pair<SkuProduct, Int> = assignSku.curry()

// test :
fun main() {
    val prod1 = Product("1", "cheese")
    val prod2 = Product("2", "Bread")
    val prod3 = Product("3", "Cake")

//    SkuProduct(prod1, createSku()) pipe ::println
//    SkuProduct(prod2, createSku()) pipe ::println
//    SkuProduct(prod3, createSku()) pipe ::println

    val state0 = 0
    val (skuProd1, state1) = curriedAssignedSku(prod1)(state0)
    skuProd1 pipe ::println
    val (skuProd2, state2) = curriedAssignedSku(prod2)(state1)
    skuProd1 pipe ::println
    val (skuProd3, state3) = curriedAssignedSku(prod3)(state2)
    skuProd1 pipe ::println



}
