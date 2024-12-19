package com.biasmj.kotlin_example.racingCar

class GameValidator {
    fun getCarNames(input: String): List<Car> {
        require(input.isNotBlank()) { "Car names must not be blank." }
        require(input.contains(",")) { "There must be at least two players." }
        val carNames = input.split(",").map { it.trim() }
        require(carNames.all { it.length <= 5 }) { "Car names must be 5 characters or less." }
        return carNames.map { Car(it) }
    }

    fun getRounds(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number of rounds.")
    }
}