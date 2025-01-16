package com.biasmj.kotlin_example.config

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class PropertiesConfigTest {

    @Test
    fun `read properties`() {
        val properties = Properties().apply {
            Thread.currentThread().contextClassLoader.getResourceAsStream("application.properties").use { load(it) }
        }

        assertEquals("3000", properties.getProperty("taxi.baseFare"))
        assertEquals("1000", properties.getProperty("taxi.perKmFare"))
        assertEquals("1.5", properties.getProperty("taxi.nightSurcharge"))
    }
}