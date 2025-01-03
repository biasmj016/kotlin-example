package com.biasmj.kotlin_example.lotto

import kotlin.random.Random

class LottoGame(private val lottoMachine: LottoMachine) {

    fun drawWinningNumbers(): Lotto {
        return lottoMachine.generateNumbers()
    }

    fun drawBonusNumber(lotto: Lotto): Int {
        return generateSequence { Random.nextInt(1, 46) }
            .first { it !in lotto.numbers }
    }

    fun check(lotto: Lotto, winningNumbers: Lotto, bonusNumber: Int): LottoWinnings {
        return LottoWinnings.getWinnings(
            lotto.numbers.count { it in winningNumbers.numbers },
            bonusNumber in lotto.numbers
        )
    }

    fun calculateProfit(purchaseAmount: Int, winnings: Int): Double {
        return (if (purchaseAmount > 0) winnings.toDouble() / purchaseAmount * 100 else 0.0).round(2)
    }

    private fun Double.round(decimals: Int): Double {
        return "%.${decimals}f".format(this).toDouble()
    }
}