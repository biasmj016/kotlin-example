package com.biasmj.kotlin_example.bowling

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/*
요구 사항
최종 목표는 볼링 점수를 계산하는 프로그램을 구현한다.
1단계 목표는 점수 계산을 제외한 볼링 게임 점수판을 구현하는 것이다.
각 프레임이 스트라이크이면 "X", 스페어이면 "9 | /", 미스이면 "8 | 1", 과 같이 출력하도록 구현한다.
스트라이크(strike) : 프레임의 첫번째 투구에서 모든 핀(10개)을 쓰러트린 상태
스페어(spare) : 프레임의 두번재 투구에서 모든 핀(10개)을 쓰러트린 상태
미스(miss) : 프레임의 두번재 투구에서도 모든 핀이 쓰러지지 않은 상태
거터(gutter) : 핀을 하나도 쓰러트리지 못한 상태.
    거터는 "-"로 표시 10 프레임은 스트라이크이거나 스페어이면 한 번을 더 투구할 수 있다.
*/
class BowlingGameTest {

    @Test
    fun test_in_perfect() {
        val game = BowlingGame()
        repeat(12) { game.roll(10) }
        assertEquals(300, game.score())
    }

    @Test
    fun test_all_spare() {
        val game = BowlingGame()
        repeat(21) { game.roll(5) }
        assertEquals(150, game.score())
    }
}