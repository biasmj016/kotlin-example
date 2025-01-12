package com.biasmj.kotlin_example.baseball

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class BaseBallGameTest {
    private val inputHandler = mock(InputHandler::class.java)
    private val outputHandler = mock(OutputHandler::class.java)
    private val numberGenerator = mock(NumberGenerator.Companion::class.java)
    private val baseBallGame = BaseBallGame(inputHandler, outputHandler, numberGenerator)

    @Test
    fun testStart() {
        val randomNumbers = listOf(1, 2, 3)
        `when`(numberGenerator.generate()).thenReturn(randomNumbers)

        `when`(inputHandler.getInput()).thenReturn(listOf(1, 2, 3))
        `when`(outputHandler.calculate(randomNumbers, listOf(1, 2, 3))).thenReturn("3스트라이크")

        assertTrue(baseBallGame.start())
        verify(inputHandler).getInput()
        verify(outputHandler).calculate(randomNumbers, listOf(1, 2, 3))
        verify(numberGenerator).generate()
    }

    @Test
    fun testPromptRestart() {
        `when`(inputHandler.promptRestart()).thenReturn(true)
        assertTrue(baseBallGame.promptRestart())
        verify(inputHandler).promptRestart()
    }
}
