package com.biasmj.kotlin_example.lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun validCheck_lottos() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.numbers)
    }

    @Test
    fun validCheck_numbers() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5))
        }
        assertEquals("A Lotto must have exactly 6 numbers.", exception.message)
    }

    @Test
    fun validCheck_invalid_numbers() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(0, 2, 3, 4, 5, 46))
        }
        assertEquals("Lotto numbers must be in 1-45.", exception.message)
    }

    @Test
    fun validCheck_duplicate_numbers() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
        assertEquals("Lotto numbers must be unique.", exception.message)
    }
}