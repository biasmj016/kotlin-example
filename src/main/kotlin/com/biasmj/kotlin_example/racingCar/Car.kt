package com.biasmj.kotlin_example.racingCar

import kotlin.random.Random

class Car(val name: String) {
    var position = 0
        private set

    fun move() {
        if (Random.nextInt(10) >= 4) position++
    }

    override fun toString() = "$name : ${"-".repeat(position)}"
}