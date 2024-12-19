package com.biasmj.kotlin_example.racingCar

class RacingGame(private val cars: List<Car>, private val rounds: Int) {
    fun start() {
        repeat(rounds) { round ->
            println("Round ${round + 1} of $rounds")
            cars.forEach { it.move() }
            printStatus()
        }
        printWinners()
    }
    private fun printStatus() {
        cars.forEach { println(it) }
        println()
    }

    private fun printWinners() {
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
        println("Winner: $winners")
    }
}