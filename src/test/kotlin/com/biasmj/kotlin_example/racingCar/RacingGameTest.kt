package com.biasmj.kotlin_example.racingCar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `test car movement`() {
        val car = Car("Test")
        car.move()
        assertTrue(car.position in 0..1)
    }
}