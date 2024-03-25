package com.example.state


val products = FList.of(
    Product("1", "Eggs"),
    Product("2", "Flour"),
    Product("3", "Cake"),
    Product("4", "Pizza"),
    Product("5", "Water")
)
var currentCount = 0

/**
 * map function doesnt work
 */
//fun inventoryMap(product: FList<Product>): FList<SkuProduct> {
//    return product.map
//}