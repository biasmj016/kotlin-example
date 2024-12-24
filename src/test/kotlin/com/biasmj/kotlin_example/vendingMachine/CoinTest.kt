package com.biasmj.kotlin_example.vendingMachine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CoinTest {

    @Test
    fun reduce() {
        val coin = Coin(denomination = 100, count = 10)
        coin.reduce(3)
        assertEquals(7, coin.count)

        assertThrows<IllegalArgumentException> {
            coin.reduce(8)
        }
    }
}