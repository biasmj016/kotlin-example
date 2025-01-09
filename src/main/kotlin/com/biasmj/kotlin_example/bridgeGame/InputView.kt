package com.biasmj.kotlin_example.bridgeGame

class InputView {
    fun inputLength(): Int {
        println("다리의 길이를 입력해주세요.")
        return readln().toInt()
    }

    fun inputMove(): String {
        println("이동할 칸을 선택해주세요. (위: U, 아래: D)")
        return readln()
    }

    fun inputRetry(): String {
        println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
        return readln()
    }
}