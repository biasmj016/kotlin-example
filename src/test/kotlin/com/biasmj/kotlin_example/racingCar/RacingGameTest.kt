package com.biasmj.kotlin_example.racingCar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingGameTest {

    @Test
    fun `test car movement`() {
        val car = Car("Test")
        car.move()
        assertTrue(car.position in 0..1)
    }

    @Test
    fun `test car names validation`() {
        val validator = GameValidator()
        val cars = validator.getCarNames("Car1,Car2")
        assertEquals(2, cars.size)
        assertEquals("Car1", cars[0].name)
        assertEquals("Car2", cars[1].name)
    }

    @Test
    fun `test car names blank validation`() {
        val validator = GameValidator()
        val exception = assertThrows<IllegalArgumentException> {
            validator.getCarNames("")
        }
        assertEquals("Car names must not be blank.", exception.message)
    }

    @Test
    fun `test car names length validation`() {
        val validator = GameValidator()
        val exception = assertThrows<IllegalArgumentException> {
            validator.getCarNames("TestCarName,Car2")
        }
        assertEquals("Car names must be 5 characters or less.", exception.message)
    }

    @Test
    fun `test car names player count validation`() {
        val validator = GameValidator()
        val exception = assertThrows<IllegalArgumentException> {
            validator.getCarNames("Car1")
        }
        assertEquals("There must be at least two players.", exception.message)
    }

    @Test
    fun `test rounds validation`() {
        val validator = GameValidator()
        val rounds = validator.getRounds("5")
        assertEquals(5, rounds)
    }

    @Test
    fun `test invalid rounds validation`() {
        val validator = GameValidator()
        val exception = assertThrows<IllegalArgumentException> {
            validator.getRounds("invalid")
        }
        assertEquals("Invalid number of rounds.", exception.message)
    }

    @Test
    fun `test racing game`() {
        val cars = listOf(Car("Car1"), Car("Car2"))
        val game = RacingGame(cars, 3)
        game.start()
        assertTrue(cars.all { it.position >= 0 })
    }
}