package com.biasmj.kotlin_example.lotto

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class LottoWinningsTest {

    @Test
    fun getWinnings_first() {
        val result = LottoWinnings.getWinnings(6)
        assertEquals(LottoWinnings.FIRST, result)
    }

    @Test
    fun getWinnings_second() {
        val result = LottoWinnings.getWinnings(5, true)
        assertEquals(LottoWinnings.SECOND, result)
    }

    @Test
    fun getWinnings_other() {
        val result = LottoWinnings.getWinnings(3)
        assertEquals(LottoWinnings.FIFTH, result)
    }

    @Test
    fun getWinnings_none() {
        val result = LottoWinnings.getWinnings(1)
        assertEquals(LottoWinnings.NONE, result)
    }
}