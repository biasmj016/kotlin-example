package com.biasmj.kotlin_example.baseball

class OutputHandler {
    fun calculate(computerNumbers: List<Int>, userNumbers: List<Int>): String {
        val strikes = userNumbers.filterIndexed { index, num -> num == computerNumbers[index] }.size
        val balls = userNumbers.count { it in computerNumbers } - strikes
        return BaseBallResult.formatResult(strikes, balls)
    }
}