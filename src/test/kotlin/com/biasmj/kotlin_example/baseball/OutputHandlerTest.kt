package com.biasmj.kotlin_example.baseball

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class OutputHandlerTest {
    private val outputHandler = OutputHandler()

    @Test
    fun testCalculate() {
        val randomNumbers = listOf(1, 2, 3)
        val inputNumbers = listOf(1, 2, 3)
        assertEquals("3스트라이크", outputHandler.calculate(randomNumbers, inputNumbers))

        val inputNumbers2 = listOf(1, 3, 2)
        assertEquals("2볼 1스트라이크", outputHandler.calculate(randomNumbers, inputNumbers2))

        val inputNumbers3 = listOf(4, 5, 6)
        assertEquals("낫싱", outputHandler.calculate(randomNumbers, inputNumbers3))
    }
}