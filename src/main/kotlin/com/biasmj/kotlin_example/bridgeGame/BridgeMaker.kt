package com.biasmj.kotlin_example.bridgeGame

import kotlin.random.Random

class BridgeMaker {
    fun makeBridge(length: Int): List<String> {
        return List(length) { if (Random.nextInt(2) == 0) "D" else "U" }
    }
}