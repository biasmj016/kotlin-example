package com.biasmj.kotlin_example.baseball

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NumberGeneratorTest {
    @Test
    fun generate() {
        val numbers = NumberGenerator.generate()
        assertEquals(3, numbers.size)
        assertTrue(numbers.all { it in 1..9 })
    }
}