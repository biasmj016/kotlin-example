package com.biasmj.kotlin_example.bridgeGame

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BridgeMakerTest {
    private val bridgeMaker = BridgeMaker()

    @Test
    fun testMakeBridge() {
        val length = 5
        val bridge = bridgeMaker.makeBridge(length)
        assertEquals(length, bridge.size)
        assertTrue(bridge.all { it == "U" || it == "D" })
    }
}