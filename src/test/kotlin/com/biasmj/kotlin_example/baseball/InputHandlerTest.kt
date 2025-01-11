package com.biasmj.kotlin_example.baseball

import kotlin.test.Test
import kotlin.test.assertFailsWith

class InputHandlerTest {
    private val inputHandler = InputHandler()

    @Test
    fun testValidateInput() {
        assertFailsWith<IllegalArgumentException> { inputHandler.validate("1234") }
        assertFailsWith<IllegalArgumentException> { inputHandler.validate("12a") }
        assertFailsWith<IllegalArgumentException> { inputHandler.validate("112") }
    }
}