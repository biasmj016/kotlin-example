package com.biasmj.kotlin_example.baseball

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BaseBallResultTest {

    @Test
    fun testMakeCounts() {
        assertEquals(BaseBallResult.THREE_STRIKES, BaseBallResult.makeCounts(3, 0))
        assertEquals(BaseBallResult.NOTHING, BaseBallResult.makeCounts(0, 0))
        assertEquals(BaseBallResult.BALLS_AND_STRIKES, BaseBallResult.makeCounts(1, 2))
    }

    @Test
    fun testFormatResult() {
        assertEquals("3스트라이크", BaseBallResult.formatResult(3, 0))
        assertEquals("낫싱", BaseBallResult.formatResult(0, 0))
        assertEquals("2볼 1스트라이크", BaseBallResult.formatResult(1, 2))
    }
}