package com.biasmj.kotlin_example.config

import java.io.FileInputStream
import java.io.IOException
import java.util.*

object PropertiesConfig {
    private val properties: Properties = Properties().apply {
        try {
            FileInputStream("application.properties").use { load(it) }
        } catch (e: IOException) {
            throw RuntimeException("Failed to load properties file: application.properties", e)
        }
    }

    fun get(key: String): String {
        return properties.getProperty(key) ?: throw IllegalArgumentException("Property '$key' not found.")
    }
}