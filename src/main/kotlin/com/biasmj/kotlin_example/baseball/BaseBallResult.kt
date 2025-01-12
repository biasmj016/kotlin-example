package com.biasmj.kotlin_example.baseball

enum class BaseBallResult {
    THREE_STRIKES,
    NOTHING,
    BALLS_AND_STRIKES;

    companion object {
        fun makeCounts(strikes: Int, balls: Int): BaseBallResult {
            return when {
                strikes == 3 -> THREE_STRIKES
                strikes == 0 && balls == 0 -> NOTHING
                else -> BALLS_AND_STRIKES
            }
        }

        fun formatResult(strikes: Int, balls: Int): String {
            return when (makeCounts(strikes, balls)) {
                THREE_STRIKES -> "3스트라이크"
                NOTHING -> "낫싱"
                BALLS_AND_STRIKES -> "${balls}볼 ${strikes}스트라이크"
            }
        }
    }
}
