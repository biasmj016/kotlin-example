package com.biasmj.kotlin_example.baseball

class InputHandler {

    fun getInput(): List<Int> {
        while (true) {
            print("숫자를 입력해주세요 : ")
            val input = readlnOrNull()
            try {
                return validate(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validate(input: String?): List<Int> {
        require(!input.isNullOrEmpty() && input.length == 3) { "잘못된 입력입니다. 3자리의 숫자를 입력해주세요." }
        val numbers = input.map { it.digitToIntOrNull() ?: throw IllegalArgumentException("숫자만 입력 가능합니다.") }
        require(numbers.distinct().size == 3) { "서로 다른 3자리의 숫자를 입력해주세요." }
        return numbers
    }

    fun promptRestart(): Boolean {
        while (true) {
            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ")
            when (readlnOrNull()) {
                "1" -> return true
                "2" -> return false
                else -> println("잘못된 입력입니다. 1 또는 2를 입력해주세요.")
            }
        }
    }
}
