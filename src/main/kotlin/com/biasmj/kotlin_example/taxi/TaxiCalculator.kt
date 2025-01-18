package com.biasmj.kotlin_example.taxi

import com.biasmj.kotlin_example.config.ConfigProvider

class TaxiCalculator(private val config: ConfigProvider) {
    private val baseFare: Double by lazy { config.get("taxi.baseFare").toDouble() }
    private val perKmFare: Double by lazy { config.get("taxi.perKmFare").toDouble() }
    private val nightSurcharge: Double by lazy { config.get("taxi.nightSurcharge").toDouble() }

    fun calculateFare(distance: Double, isNightTime: Boolean): Double {
        val distanceFare = calculateDistanceFare(distance)
        return applyNightSurcharge(distanceFare, isNightTime)
    }

    private fun calculateDistanceFare(distance: Double): Double {
        return baseFare + (distance * perKmFare)
    }

    private fun applyNightSurcharge(fare: Double, isNightTime: Boolean): Double {
        return if (isNightTime) fare * nightSurcharge else fare
    }
}