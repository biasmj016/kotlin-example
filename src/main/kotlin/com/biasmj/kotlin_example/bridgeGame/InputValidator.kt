package com.biasmj.kotlin_example.bridgeGame

class InputValidator {
    fun validateBridgeLength(length: Int) {
        require(length in 3..20) { "[ERROR] 다리의 길이는 3부터 20 사이의 숫자여야 합니다." }
    }

    fun validateMove(move: String) {
        require(move == "U" || move == "D") { "[ERROR] 이동할 칸은 U 또는 D여야 합니다." }
    }

    fun validateRetry(retry: String) {
        require(retry == "R" || retry == "Q") { "[ERROR] 입력은 R 또는 Q여야 합니다." }
    }
}