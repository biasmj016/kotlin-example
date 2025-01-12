package com.biasmj.kotlin_example.baseball

class BaseBallGame(
    private val inputHandler: InputHandler = InputHandler(),
    private val outputHandler: OutputHandler = OutputHandler(),
    private val numberGenerator: NumberGenerator.Companion = NumberGenerator
) {
    private lateinit var randomNumbers: List<Int>

    fun start(): Boolean {
        randomNumbers = numberGenerator.generate()
        return play()
    }
    private fun play(): Boolean {
        do {
            val userNumbers = inputHandler.getInput()
            val result = outputHandler.calculate(randomNumbers, userNumbers)
            println(result)
        } while (result != "3스트라이크")
        return true
    }

    fun promptRestart(): Boolean {
        return inputHandler.promptRestart()
    }
}
