package com.biasmj.kotlin_example.bridgeGame
/*
- 기능 구현 요구사항
1. 다리 길이 입력
다리 길이는 3 ~ 20 사이의 숫자여야 한다.
숫자가 아니거나 범위를 벗어난 경우, [ERROR] 메시지와 함께 IllegalStateException 발생.

2. 다리 생성
입력한 길이만큼 무작위로 0(아래칸) 또는 1(위칸) 값을 생성.
다리는 [ ]로 감싸고, 칸 구분은 |(앞뒤 공백 포함)으로 표시.
0인 경우 D(아래칸), 1인 경우 U(위칸)으로 설정.

3. 플레이어 진행
각 라운드에서 플레이어는 U(위 칸) 또는 **D(아래 칸)**으로 이동 입력.
이동 결과:
올바른 이동: O로 표시.
잘못된 이동: X로 표시하고 재시도 여부 확인.
R(재시도): 처음부터 다시 진행.
Q(종료): 최종 결과 출력 후 게임 종료.
선택되지 않은 칸은 공백으로 표시.

4. 게임 종료 조건
플레이어가 다리 끝까지 도달하면 성공.
이동 실패 후 종료를 선택하면 실패.

5. 결과 출력
최종 다리 상태와 플레이어가 이동한 칸 결과를 표시.
성공 여부와 총 시도 횟수를 출력.
*/

fun main() {
    val bridgeMaker = BridgeMaker()
    val game = BridgeGame(bridgeMaker)
    val inputView = InputView()
    val outputView = OutputView()
    val validator = InputValidator()

    try {
        val length = inputView.inputLength()
        validator.validateBridgeLength(length)
        game.start(length)

        while (true) {
            val move = inputView.inputMove()
            validator.validateMove(move)
            val isGameRunning = game.processMove(move) {
                val retry = inputView.inputRetry()
                validator.validateRetry(retry)
                retry
            }

            outputView.printBridge(game.getBridge(), game.getPlayerMoves())
            if (!isGameRunning || game.isGameSuccess()) break
        }

        outputView.printResult(game.getBridge(), game.isGameSuccess(), game.getAttempts())
    } catch (e: Exception) {
        println(e.message)
    }
}
