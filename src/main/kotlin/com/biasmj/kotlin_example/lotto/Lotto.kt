package com.biasmj.kotlin_example.lotto

data class Lotto(val numbers: Set<Int>) {
    init {
        require(numbers.distinct().size == 6) { "A Lotto is required to have precisely 6 numbers." }
        require(numbers.all { it in 1..45 }) { "Lotto numbers must be in 1-45." }
    }
}