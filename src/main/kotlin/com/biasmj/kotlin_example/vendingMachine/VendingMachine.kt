package com.biasmj.kotlin_example.vendingMachine

class VendingMachine(initialCoins: Map<Int, Int>) {
    private val coinInventory = CoinInventory(initialCoins)
    private val productInventory = ProductInventory()
    private var totalInsertedAmount = 0

    fun addProduct(name: String, price: Int, quantity: Int) {
        productInventory.addProduct(name, price, quantity)
    }

    fun insertCoin(amount: Int) {
        require(amount > 0 && amount % 10 == 0) { "Invalid amount inserted." }
        totalInsertedAmount += amount
        println("Inserted: $amount. Total: $totalInsertedAmount.")
    }

    fun buy(productName: String) {
        val product = productInventory.getProduct(productName)
        require(totalInsertedAmount >= product.price) { "Insufficient funds to purchase $productName." }

        product.reduce()
        totalInsertedAmount -= product.price
        println("Product purchased: $productName")

        if (totalInsertedAmount < productInventory.getMinPrice() ||
            productInventory.isAllSoldOut()
        ) returnChange()
    }

    private fun returnChange() {
        val change = coinInventory.makeChange(totalInsertedAmount)

        if (change.remainingAmount > 0) throw IllegalStateException("[ERROR] Unable to return full change. Remaining amount: ${change.remainingAmount}")

        totalInsertedAmount = 0
        println("Change returned: ${change.changeMap.entries.joinToString { "${it.key}원 ${it.value}개" }}")
    }

    fun display() {
        productInventory.displayProducts()
    }

    fun displayCoinInventory() {
        coinInventory.displayCoinInventory()
    }
}