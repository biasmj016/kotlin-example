package com.biasmj.kotlin_example.vendingMachine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CoinInventoryTest {

    @Test
    fun makeChange() {
        val initialCoins = mapOf(10 to 10, 50 to 10, 100 to 10, 500 to 10)
        val coinInventory = CoinInventory(initialCoins)
        val change = coinInventory.makeChange(380)
        assertEquals(0, change.remainingAmount)
        assertEquals(mapOf(100 to 3, 50 to 1, 10 to 3), change.changeMap)
    }

    @Test
    fun displayCoinInventory() {
        val initialCoins = mapOf(10 to 10, 50 to 10, 100 to 10, 500 to 10)
        val coinInventory = CoinInventory(initialCoins)
        coinInventory.displayCoinInventory()
    }
}