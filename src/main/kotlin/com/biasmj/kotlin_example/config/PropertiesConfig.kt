package com.biasmj.kotlin_example.config

import java.util.*

object PropertiesConfig : ConfigProvider {
    private val properties: Properties = Properties().apply {
        val classLoader = Thread.currentThread().contextClassLoader
        val resourceStream = classLoader?.getResourceAsStream("application.properties")
            ?: throw RuntimeException("Failed to load properties file: application.properties")
        resourceStream.use { load(it) }
    }

    override fun get(key: String): String {
        return properties.getProperty(key)
            ?: throw IllegalArgumentException("Property $key not found in application.properties")
    }
}
