package com.biasmj.kotlin_example.baseball

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NumberGeneratorTest {
    private val numberGenerator = NumberGenerator()

    @Test
    fun generate() {
        val numbers = numberGenerator.generate()
        assertEquals(3, numbers.size)
        assertTrue(numbers.all { it in 1..9 })
    }
}