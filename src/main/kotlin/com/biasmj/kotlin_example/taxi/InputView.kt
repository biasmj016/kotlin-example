package com.biasmj.kotlin_example.taxi

class InputView {
    companion object {
        private const val DISTANCE_PROMPT = "이동 거리를 입력하세요 (km):"
        private const val NIGHT_TIME_PROMPT = "야간 시간인가요? (yes/no):"
        private const val INVALID_DISTANCE_MESSAGE = "유효한 거리를 입력하세요 (0 이상)."
        private const val INVALID_INPUT_MESSAGE = "유효한 입력을 하세요 (yes 또는 no)."
    }

    fun getDistance(): Double {
        println(DISTANCE_PROMPT)
        return readlnOrNull()?.toDoubleOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(INVALID_DISTANCE_MESSAGE)
    }

    fun isNightTime(): Boolean {
        println(NIGHT_TIME_PROMPT)
        val input = readlnOrNull()?.trim()?.lowercase()
        return when (input) {
            "yes", "y" -> true
            "no", "n" -> false
            else -> throw IllegalArgumentException(INVALID_INPUT_MESSAGE)
        }
    }
}