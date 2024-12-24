package com.biasmj.kotlin_example.vendingMachine

class Product(val name: String, val price: Int, private var quantity: Int) {
    fun reduce() {
        require(quantity > 0) { "$name is sold out." }
        quantity--
    }

    fun isSoldOut() = quantity == 0

    override fun toString() = "$name: $price ($quantity left)"
}