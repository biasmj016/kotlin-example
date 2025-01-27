package com.biasmj.kotlin_example.lotto

/*
로또 기본 규칙
로또 번호는 1부터 45까지의 숫자 중에서 선택됩니다.
로또 티켓은 중복되지 않는 6개의 숫자로 구성됩니다.
당첨 번호는 중복되지 않는 6개의 숫자와 보너스 번호 1개로 구성됩니다.

당첨 기준 및 상금
1등: 6개 번호가 모두 일치하면 당첨, 상금은 20억 원.
2등: 5개 번호가 일치하고 보너스 번호가 일치하면 당첨, 상금은 3천만 원.
3등: 5개 번호가 일치하면 당첨, 상금은 150만 원.
4등: 4개 번호가 일치하면 당첨, 상금은 5만 원.
5등: 3개 번호가 일치하면 당첨, 상금은 5천 원.

기능 구현 목록
1. 로또 구입 처리
사용자는 구입 금액을 입력할 수 있습니다.
입력한 금액은 반드시 1,000원으로 나누어떨어져야 합니다.(입력한 금액에 따라 여러 장의 로또 티켓이 생성됩니다.)

2. 로또 번호 생성
각 로또 티켓은 1부터 45까지의 숫자 중 중복되지 않는 6개의 숫자로 구성됩니다.(생성된 숫자는 오름차순으로 정렬됩니다.)

3. 당첨 번호 입력
사용자는 중복되지 않는 6개의 당첨 번호를 입력합니다.(당첨 번호는 오름차순으로 정렬됩니다.)
보너스 번호를 추가로 입력합니다.

4. 당첨 결과 확인
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 확인합니다.
번호 개수와 보너스 번호의 일치 여부를 기반으로 당첨 등수를 결정합니다.
각 등수에 따른 당첨 금액을 확인합니다.

5. 수익률 계산
총 당첨 금액을 구입 금액으로 나눈 뒤, 100을 곱해 수익률을 계산합니다.
계산된 수익률은 소수점 둘째 자리에서 반올림하여 출력합니다.

*/

fun main() {
    val lottoMachine = LottoMachine()
    val lottoGame = LottoGame(lottoMachine)

    while (true) {
        try {
            println("구입 금액을 입력해주세요")
            val purchaseAmount = readLine()!!.toInt()
            val lottos = lottoMachine.purchase(purchaseAmount)
            println("${lottos.size}개를 구매했습니다.")
            lottos.forEach { println(it.numbers) }

            println("로또를 시작합니다.")
            val winningNumbers = lottoGame.drawWinningNumbers()
            val bonusNumber = lottoGame.drawBonusNumber(winningNumbers)
            println("당첨번호 : ${winningNumbers.numbers}")
            println("보너스 번호 : $bonusNumber")

            val results = lottos.map { lottoGame.check(it, winningNumbers, bonusNumber) }
            val winnings = results.sumOf { it.winnings }
            val profit = lottoGame.calculateProfit(purchaseAmount, winnings)

            println("당첨 통계")
            println("---------")
            results.groupingBy { it }.eachCount().forEach { (winnings, count) ->
                println("${winnings.count}개 일치 (${winnings.winnings}원)- ${count}개")
            }
            println("총 수익률은 $profit%입니다.")

            break
        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}