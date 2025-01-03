package com.biasmj.kotlin_example.lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {

    private lateinit var lottoMachine: LottoMachine

    @BeforeEach
    fun setUp() {
        lottoMachine = LottoMachine()
    }

    @Test
    fun purchase_validAmount() {
        val result = lottoMachine.purchase(3000)
        assertEquals(3, result.size)
        result.forEach { lotto ->
            assertEquals(6, lotto.numbers.size)
            assertTrue(lotto.numbers.all { it in 1..45 })
        }
    }

    @Test
    fun purchase_invalidAmount() {
        assertThrows<IllegalArgumentException> {
            lottoMachine.purchase(2500)
        }
    }

    @Test
    fun generateNumbers() {
        val result = lottoMachine.generateNumbers()
        assertEquals(6, result.numbers.size)
        assertTrue(result.numbers.all { it in 1..45 })
    }
}