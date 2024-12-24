package com.biasmj.kotlin_example.vendingMachine

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProductTest {

    @Test
    fun purchase() {
        val product = Product(name = "Soda", price = 250, quantity = 3)

        assertThrows<IllegalArgumentException> {
            repeat(5) { product.reduce() }
        }
    }

    @Test
    fun isSoldOut() {
        val product = Product(name = "Soda", price = 250, quantity = 1)
        product.reduce()
        assertTrue(product.isSoldOut())
    }
}