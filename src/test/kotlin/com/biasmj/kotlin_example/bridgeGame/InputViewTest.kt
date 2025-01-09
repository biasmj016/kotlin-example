package com.biasmj.kotlin_example.bridgeGame

import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream
import java.io.InputStream
import kotlin.test.Test

class InputViewTest {
    private val inputView = InputView()

    @Test
    fun testInputLength() {
        val input = "3\n"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        assertEquals(3, inputView.inputLength())
    }

    @Test
    fun testInputMove() {
        val input = "U\n"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        assertEquals("U", inputView.inputMove())
    }

    @Test
    fun testInputRetry() {
        val input = "R\n"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        assertEquals("R", inputView.inputRetry())
    }
}