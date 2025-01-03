package com.biasmj.kotlin_example.lotto

import kotlin.random.Random

class LottoMachine {
    fun purchase(amount: Int): List<Lotto> {
        require(amount % 1000 == 0) { "Amount must be a multiple of 1000." }
        return List(amount / 1000) { generateNumbers() }
    }

    fun generateNumbers(): Lotto {
        return Lotto(
            generateSequence { Random.nextInt(1, 46) }
                .distinct()
                .take(6)
                .toSortedSet()
        )
    }
}