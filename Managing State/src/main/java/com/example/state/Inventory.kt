package com.example.state

// we want to assign a SKU to this data class aka: stock keeping unit (which is a scannable barcode)
data class Product(val id: String, val name: String)
data class SkuProduct(val product: Product, val sku: String)

var count = 0
fun createSku(): String = "RAY-PROD-${String.format("%04d", count++)}"

// test :
fun main() {
    val prod1 = Product("1", "cheese")
    val prod2 = Product("2", "Bread")
    val prod3 = Product("3", "Cake")

    SkuProduct(prod1, createSku()) pipe ::println
    SkuProduct(prod2, createSku()) pipe ::println
    SkuProduct(prod3, createSku()) pipe ::println



}
