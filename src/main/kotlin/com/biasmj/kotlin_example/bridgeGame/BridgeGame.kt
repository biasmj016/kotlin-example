package com.biasmj.kotlin_example.bridgeGame

class BridgeGame(private val bridgeMaker: BridgeMaker) {
    private var attempts = 0
    private lateinit var bridge: List<String>
    private val playerMoves = mutableListOf<String>()
    private var isSuccess = false

    fun start(length: Int) {
        bridge = bridgeMaker.makeBridge(length)
        attempts = 1
        playerMoves.clear()
        isSuccess = false
    }

    fun move(move: String): Boolean {
        playerMoves.add(move)
        val isCorrectMove = bridge[playerMoves.size - 1] == move
        if (isCorrectMove && playerMoves.size == bridge.size) {
            isSuccess = true
        }
        return isCorrectMove
    }

    fun retry() {
        attempts++
        playerMoves.clear()
    }

    fun processMove(move: String, retryDecision: () -> String): Boolean {
        if (!move(move)) {
            val retry = retryDecision()
            if (retry == "Q") return false
            retry()
        }
        return true
    }

    fun isGameSuccess() = isSuccess
    fun getAttempts() = attempts
    fun getPlayerMoves() = playerMoves
    fun getBridge() = bridge
}
