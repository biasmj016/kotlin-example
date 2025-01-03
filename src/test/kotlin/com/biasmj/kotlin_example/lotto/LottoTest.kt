package com.biasmj.kotlin_example.lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {

    @Test
    fun validCheck_lottos() {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        assertEquals(setOf(1, 2, 3, 4, 5, 6), lotto.numbers)
    }

    @Test
    fun validCheck_duplicate_numbers() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(setOf(1, 2, 3, 4, 5, 5))
        }
        assertEquals("A Lotto is required to have precisely 6 numbers.", exception.message)
    }

    @Test
    fun validCheck_invalid_numbers() {
        val exception = assertThrows<IllegalArgumentException> {
            Lotto(setOf(0, 2, 3, 4, 5, 46))
        }
        assertEquals("Lotto numbers must be in 1-45.", exception.message)
    }
}