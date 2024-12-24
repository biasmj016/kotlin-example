package com.biasmj.kotlin_example.vendingMachine

/*
- 기능 요구사항
반환되는 동전이 최소한이 되는 자판기를 구현한다.

자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
투입 금액으로는 동전을 생성하지 않는다.
잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다.
상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.
사용자가 투입한 금액으로 상품을 구매할 수 있다.
남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
반환되지 않은 금액은 자판기에 남는다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
*/

fun main() {
    val initialCoins = mapOf(10 to 10, 50 to 10, 100 to 10, 500 to 10)
    val vendingMachine = VendingMachine(initialCoins)

    vendingMachine.addProduct("Coke", 290, 5)
    vendingMachine.addProduct("Cider", 100, 1)
    vendingMachine.addProduct("Milk", 500, 15)

    vendingMachine.display()
    vendingMachine.displayCoinInventory()

    vendingMachine.insertCoin(380)
    vendingMachine.buy("Coke")
    vendingMachine.display()
    vendingMachine.displayCoinInventory()
}