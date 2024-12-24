package com.biasmj.kotlin_example.vendingMachine

class ProductInventory {
    private val products = mutableListOf<Product>()

    fun addProduct(name: String, price: Int, quantity: Int) {
        require(price >= 100 && price % 10 == 0 && quantity > 0) {
            "Invalid product configuration. Price must be >= 100 and divisible by 10, quantity must be > 0."
        }
        products.add(Product(name, price, quantity))
    }

    fun getProduct(name: String): Product {
        return products.find { it.name == name } ?: throw IllegalArgumentException("$name not found.")
    }

    fun getMinPrice(): Int {
        return products.minOfOrNull { it.price } ?: Int.MAX_VALUE
    }

    fun isAllSoldOut(): Boolean {
        return products.all { it.isSoldOut() }
    }

    fun displayProducts() {
        println("=========== Products ============")
        products.forEach { println(it) }
        println("=================================")
    }
}