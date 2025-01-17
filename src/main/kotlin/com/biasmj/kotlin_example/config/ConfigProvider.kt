package com.biasmj.kotlin_example.config

interface ConfigProvider {
    fun get(key: String): String
}