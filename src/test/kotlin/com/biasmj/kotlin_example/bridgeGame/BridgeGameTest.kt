package com.biasmj.kotlin_example.bridgeGame

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BridgeGameTest {
    private val game = BridgeGame(listOf("U", "D", "U", "D", "U"))

    @Test
    fun testStart() {
        game.start(5)
        assertEquals(5, game.getBridge().size)
        assertEquals(1, game.getAttempts())
        assertTrue(game.getPlayerMoves().isEmpty())
        assertFalse(game.isGameSuccess())
    }

    @Test
    fun testMove() {
        game.start(3)
        val bridge = game.getBridge()
        val move = bridge[0]
        assertTrue(game.move(move))
        assertEquals(listOf(move), game.getPlayerMoves())
    }

    @Test
    fun testMoveFailure() {
        game.start(3)
        val move = if (game.getBridge()[0] == "U") "D" else "U"
        assertFalse(game.move(move))
        assertEquals(listOf(move), game.getPlayerMoves())
    }

    @Test
    fun testRetry() {
        game.start(3)
        game.move("U")
        game.retry()
        assertEquals(2, game.getAttempts())
        assertTrue(game.getPlayerMoves().isEmpty())
    }

    @Test
    fun testProcessMove() {
        game.start(3)
        val bridge = game.getBridge()
        val move = bridge[0]
        assertTrue(game.processMove(move) { "R" })
        assertEquals(listOf(move), game.getPlayerMoves())
    }

    @Test
    fun testProcessMoveFailure() {
        game.start(3)
        val move = if (game.getBridge()[0] == "U") "D" else "U"
        assertFalse(game.processMove(move) { "Q" })
        assertEquals(1, game.getAttempts())
    }
}