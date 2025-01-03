package com.biasmj.kotlin_example.lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import kotlin.random.Random

class LottoGameTest {

    private lateinit var lottoMachine: LottoMachine
    private lateinit var lottoGame: LottoGame

    @BeforeEach
    fun setUp() {
        lottoMachine = mock(LottoMachine::class.java)
        lottoGame = LottoGame(lottoMachine)
    }

    @Test
    fun drawWinningNumbers() {
        val expectedLotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        `when`(lottoMachine.generateNumbers()).thenReturn(expectedLotto)

        assertEquals(expectedLotto, lottoGame.drawWinningNumbers())
    }

    @Test
    fun drawBonusNumber() {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val random = mock(Random::class.java)
        `when`(random.nextInt(1, 46)).thenReturn(7)

        val result = generateSequence { random.nextInt(1, 46) }
            .first { it !in lotto.numbers }

        assertEquals(7, result)
    }

    @Test
    fun check() {
        val lotto = Lotto(setOf(1, 2, 3, 4, 5, 6))
        val winningNumbers = Lotto(setOf(1, 2, 3, 4, 5, 7))
        val bonusNumber = 6
        val expectedWinnings = LottoWinnings.SECOND

        assertEquals(expectedWinnings, lottoGame.check(lotto, winningNumbers, bonusNumber))
    }

    @Test
    fun calculateProfit() {
        assertEquals(500.0, lottoGame.calculateProfit(1000, 5000))
    }
}