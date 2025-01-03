package com.biasmj.kotlin_example.lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun lottos() {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        assertEquals(setOf(1, 2, 3, 4, 5, 6), lotto.numbers)
    }
}