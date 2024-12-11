package com.biasmj.kotlin_example.bowling

class BowlingGame {
    private val frames = MutableList(10) { Frame() }
    private var currentFrame = 0

    fun roll(pins: Int) {
        if (currentFrame < 10) {
            frames[currentFrame].roll(pins)
            if (frames[currentFrame].isComplete() && currentFrame < 9) currentFrame++
        }
    }

    fun score(): Int = frames.withIndex().sumOf { (i, frame) ->
        frame.score() + when {
            frame.isStrike() && i < 9 -> frames[i + 1].firstRoll + (frames[i + 1].secondRoll ?: frames.getOrNull(i + 2)?.firstRoll ?: 0)
            frame.isSpare() && i < 9 -> frames[i + 1].firstRoll
            else -> 0
        }
    }

    fun display() = frames.forEachIndexed { index, frame -> println("Frame ${index + 1}: ${frame.display()}") }
}