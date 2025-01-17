package com.biasmj.kotlin_example.config

import java.util.*

object PropertiesConfig : ConfigProvider {
    private val properties: Properties = Properties().apply {
        javaClass.classLoader.getResourceAsStream("application.properties")?.use { load(it) }
            ?: throw RuntimeException("Failed to load properties file: application.properties")
    }

    override fun get(key: String): String {
        return properties.getProperty(key)
    }
}