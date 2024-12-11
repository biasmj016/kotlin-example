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

    fun isComplete() = firstRoll == 10 || (secondRoll != null && (firstRoll + secondRoll!! < 10 || bonusRoll != null))
    fun isStrike() = firstRoll == 10
    fun isSpare() = firstRoll + (secondRoll ?: 0) == 10 && firstRoll != 10
    fun score() = firstRoll + (secondRoll ?: 0) + (bonusRoll ?: 0)

    fun display() = when {
        isStrike() -> "X"
        isSpare() -> "$firstRoll | /"
        firstRoll == 0 && secondRoll == 0 -> "- | -"
        else -> "$firstRoll | ${secondRoll ?: ""}"
    }
}