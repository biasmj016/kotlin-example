package com.biasmj.kotlin_example.vendingMachine

class Coin(val denomination: Int, var count: Int) {
    fun reduce(countToReduce: Int) {
        require(countToReduce <= count) { "Not enough coins." }
        count -= countToReduce
    }
}