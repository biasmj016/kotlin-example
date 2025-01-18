package com.biasmj.kotlin_example.taxi

import com.biasmj.kotlin_example.config.ConfigProvider
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class TaxiCalculatorTest {

    private val mockConfig = mock(ConfigProvider::class.java).apply {
        `when`(get("taxi.baseFare")).thenReturn("3000")
        `when`(get("taxi.perKmFare")).thenReturn("1000")
        `when`(get("taxi.nightSurcharge")).thenReturn("1.5")
    }

    private val taxiCalculator = TaxiCalculator(mockConfig)

    @Test
    fun calculate() {
        val fare = taxiCalculator.calculateFare(10.0, false)
        assertEquals(13000.0, fare)
    }

    @Test
    fun calculate_nighttime() {
        val fare = taxiCalculator.calculateFare(10.0, true)
        assertEquals(19500.0, fare)
    }
}