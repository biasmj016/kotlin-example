package com.biasmj.kotlin_example.bridgeGame

class OutputView {
    fun printBridge(bridge: List<String>, moves: List<String>) {
        val top = List(bridge.size) { index -> if (moves.getOrNull(index) == "U") "O" else if (moves.size > index) "X" else " " }
        val bottom = List(bridge.size) { index -> if (moves.getOrNull(index) == "D") "O" else if (moves.size > index) "X" else " " }

        println(top.joinToString(" | ", "[", "]"))
        println(bottom.joinToString(" | ", "[", "]"))
    }

    fun printResult(bridge: List<String>, success: Boolean, attempts: Int) {
        println("최종 게임 결과:")
        printBridge(bridge, bridge)
        println("게임 성공 여부: ${if (success) "성공" else "실패"}")
        println("총 시도한 횟수: $attempts")
    }
}