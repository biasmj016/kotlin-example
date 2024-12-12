package com.biasmj.kotlin_example.bowling

class Frame {
    var firstRoll: Int = 0
    var secondRoll: Int? = null
    var bonusRoll: Int? = null

    fun roll(pins: Int) {
        when {
            firstRoll == 0 -> firstRoll = pins
            secondRoll == null -> secondRoll = pins
            else -> bonusRoll = pins
        }
    }

    fun isComplete() = isStrike() || secondRoll?.let { isSpare() || bonusRoll != null || firstRoll + it < 10 } == true
    fun isStrike() = firstRoll == 10
    fun isSpare() = secondRoll?.let { firstRoll + it == 10 && !isStrike() } == true
    fun score() = firstRoll + (secondRoll ?: 0) + (bonusRoll ?: 0)

    fun display() = when {
        isStrike() -> buildString { append("X").also { bonusRoll?.let { append(" | $secondRoll | $it") } } }
        isSpare() -> "$firstRoll | /"
        firstRoll == 0 -> "- | ${secondRoll?.toString() ?: "-"}"
        secondRoll == 0 -> "$firstRoll | -"
        else -> "$firstRoll | $secondRoll"
    }
}