package com.biasmj.kotlin_example.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BowlingGameTest {

    @Test
    fun test_in_perfect() {
        val game = BowlingGame()
        repeat(12) { game.roll(10) }
        assertEquals(300, game.score())
    }

    @Test
    fun test_all_spare() {
        val game = BowlingGame()
        repeat(21) { game.roll(5) }
        assertEquals(150, game.score())
    }

    @Test
    fun test() {
        val game = BowlingGame()
        listOf(10, 9, 1, 8, 1, 0, 0, 10, 7, 3, 6, 2, 10, 10, 10, 10, 10).forEach { game.roll(it) }
        assertEquals(193, game.score())
    }
}