package com.biasmj.kotlin_example.vendingMachine

class CoinInventory(initialCoins: Map<Int, Int>) {
    private val coinInventory = initialCoins.mapValues { Coin(it.key, it.value) }.toMutableMap()

    fun makeChange(amount: Int): Change {
        val changeMap = mutableMapOf<Int, Int>()
        var remainingAmount = amount

        coinInventory.entries.sortedByDescending { it.key }.forEach { (denomination, coin) ->
            val coinsToReturn = minOf(remainingAmount / denomination, coin.count)
            if (coinsToReturn > 0) {
                changeMap[denomination] = coinsToReturn
                coin.reduce(coinsToReturn)
                remainingAmount -= coinsToReturn * denomination
            }
        }

        return Change(changeMap, remainingAmount)
    }

    fun displayCoinInventory() {
        println("======== Coin Inventory =========")
        coinInventory.values.forEach { println("- ${it.denomination}원: ${it.count}개") }
        println("=================================")
    }
}

data class Change(val changeMap: Map<Int, Int>, val remainingAmount: Int)