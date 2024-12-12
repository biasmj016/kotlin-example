package com.biasmj.kotlin_example.bowling

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FrameTest {

    @Test
    fun test_rolls() {
        val frame = Frame()

        // 첫 번째 투구
        frame.roll(5)
        assertEquals(5, frame.firstRoll)
        assertNull(frame.secondRoll)
        assertNull(frame.bonusRoll)

        // 두 번째 투구
        frame.roll(3)
        assertEquals(5, frame.firstRoll)
        assertEquals(3, frame.secondRoll)
        assertNull(frame.bonusRoll)

        // 보너스 투구
        frame.roll(7)
        assertEquals(7, frame.bonusRoll)
    }

    @Test
    fun test_isStrike() {
        val frame = Frame()

        frame.roll(10) // 스트라이크 발생
        assertTrue(frame.isStrike())
        assertFalse(frame.isSpare())
        assertTrue(frame.isComplete())
    }

    @Test
    fun test_isSpare() {
        val frame = Frame()

        frame.roll(5)
        frame.roll(5) // 스페어 발생
        assertTrue(frame.isSpare())
        assertFalse(frame.isStrike())
        assertTrue(frame.isComplete())
    }

    @Test
    fun test_isComplete() {
        val frame = Frame()

        // 스트라이크
        frame.roll(10)
        assertTrue(frame.isComplete())

        // 두 번의 투구
        val anotherFrame = Frame()
        anotherFrame.roll(4)
        anotherFrame.roll(5)
        assertTrue(anotherFrame.isComplete())

        // 보너스 포함
        val bonusFrame = Frame()
        bonusFrame.roll(5)
        bonusFrame.roll(5) // 스페어
        bonusFrame.roll(3)
        assertTrue(bonusFrame.isComplete())
    }

    @Test
    fun test_score() {
        val frame = Frame()

        // 일반적 경우
        frame.roll(4)
        frame.roll(3)
        assertEquals(7, frame.score())

        // 스페어 점수
        val spareFrame = Frame()
        spareFrame.roll(5)
        spareFrame.roll(5)
        spareFrame.bonusRoll = 4
        assertEquals(14, spareFrame.score())

        // 스트라이크 점수
        val strikeFrame = Frame()
        strikeFrame.roll(10)
        strikeFrame.bonusRoll = 10
        assertEquals(20, strikeFrame.score())
    }

    @Test
    fun test_display() {
        // 일반 점수
        val frame = Frame()
        frame.roll(6)
        frame.roll(2)
        println("Frame ${frame.display()}")

        // 스트라이크
        val strikeFrame = Frame()
        strikeFrame.roll(10)
        println("Frame ${strikeFrame.display()}")

        // 스페어
        val spareFrame = Frame()
        spareFrame.roll(7)
        spareFrame.roll(3)
        println("Frame ${spareFrame.display()}")

        // 거터
        val gutterFrame = Frame()
        gutterFrame.roll(0)
        gutterFrame.roll(0)
        println("Frame ${gutterFrame.display()}")

    }
}