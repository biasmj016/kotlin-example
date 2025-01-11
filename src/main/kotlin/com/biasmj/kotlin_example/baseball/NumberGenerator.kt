package com.biasmj.kotlin_example.baseball

class NumberGenerator {
    fun  generate(): List<Int> {
        return (1..9).shuffled().take(3)
    }
}