package com.biasmj.kotlin_example.lotto

enum class LottoWinnings(val bonusMatch: Boolean, val count: Int, val winnings: Int) {
    FIRST(false,6, 2000000000),
    SECOND(true,5, 30000000),
    THIRD(false, 5, 1500000),
    FOURTH(false, 4, 50000),
    FIFTH(false, 3, 5000),
    NONE(false, 0, 0);

    companion object {
        fun getWinnings(count: Int, bonusMatched: Boolean = false): LottoWinnings {
            return entries.find { it.count == count && it.bonusMatch == bonusMatched } ?: NONE
        }
    }
}