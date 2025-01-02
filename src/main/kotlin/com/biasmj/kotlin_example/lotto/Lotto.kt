package com.biasmj.kotlin_example.lotto

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "A Lotto must have exactly 6 numbers." }
        require(numbers.distinct().size == 6) { "Lotto numbers must be unique." }
        require(numbers.all { it in 1..45 }) { "Lotto numbers must be in 1-45." }
    }
}