package com.biasmj.kotlin_example.taxi

import com.biasmj.kotlin_example.config.PropertiesConfig

fun main() {
    val inputView = InputView()
    val configProvider = PropertiesConfig
    val calculator = TaxiCalculator(configProvider)

    println("=== 택시 요금 계산기 ===")
    println("이동 거리와 야간 여부를 입력해 요금을 계산합니다.")

    try {
        val distance = inputView.getDistance()
        val isNightTime = inputView.isNightTime()

        val fare = calculator.calculateFare(distance, isNightTime)
        println("예상 택시 요금은 ${"%.0f".format(fare)}원 입니다.")
    } catch (e: IllegalArgumentException) {
        println("입력 오류: ${e.message}")
    } catch (e: Exception) {
        println("오류가 발생했습니다: ${e.message}")
    }
}
