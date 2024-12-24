package com.biasmj.kotlin_example.vendingMachine

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ProductInventoryTest {

    @Test
    fun addProduct() {
        val inventory = ProductInventory()
        inventory.addProduct("Coke", 250, 5)
        val product = inventory.getProduct("Coke")
        assertEquals("Coke", product.name)
        assertEquals(250, product.price)
    }

    @Test
    fun getProduct() {
        val inventory = ProductInventory()
        inventory.addProduct("Coke", 250, 5)
        val product = inventory.getProduct("Coke")
        assertNotNull(product)

        assertThrows<IllegalArgumentException> {
            inventory.getProduct("Test")
        }
    }

    @Test
    fun getMinPrice() {
        val inventory = ProductInventory()
        inventory.addProduct("Coke", 250, 5)
        inventory.addProduct("Milk", 100, 10)
        assertEquals(100, inventory.getMinPrice())
    }

    @Test
    fun isAllSoldOut() {
        val inventory = ProductInventory()
        inventory.addProduct("Coke", 250, 1)
        inventory.addProduct("Milk", 100, 1)
        inventory.getProduct("Coke").reduce()
        inventory.getProduct("Milk").reduce()
        assertTrue(inventory.isAllSoldOut())
    }

    @Test
    fun displayProducts() {
        val inventory = ProductInventory()
        inventory.addProduct("Coke", 250, 5)
        inventory.addProduct("Milk", 100, 10)
        inventory.displayProducts()
    }
}