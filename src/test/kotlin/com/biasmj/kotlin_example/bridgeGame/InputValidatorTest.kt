package com.biasmj.kotlin_example.bridgeGame

import kotlin.test.Test
import kotlin.test.assertFailsWith

class InputValidatorTest {
 private val validator = InputValidator()

 @Test
 fun testValidateBridgeLength() {
  validator.validateBridgeLength(5)
  assertFailsWith<IllegalArgumentException> { validator.validateBridgeLength(2) }
  assertFailsWith<IllegalArgumentException> { validator.validateBridgeLength(100) }
 }

 @Test
 fun testValidateMove() {
  validator.validateMove("U")
  validator.validateMove("D")
  assertFailsWith<IllegalArgumentException> { validator.validateMove("A") }
 }

 @Test
 fun testValidateRetry() {
  validator.validateRetry("R")
  validator.validateRetry("Q")
  assertFailsWith<IllegalArgumentException> { validator.validateRetry("A") }
 }
}