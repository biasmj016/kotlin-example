import com.biasmj.kotlin_example.bridgeGame.OutputView

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertTrue

class OutputViewTest {
    private val outputView = OutputView()

    @Test
    fun testPrintBridge() {
        val bridge = listOf("U", "D", "U")
        val moves = listOf("U", "D", "U")
        val outContent = ByteArrayOutputStream().apply { System.setOut(PrintStream(this)) }
        outputView.printBridge(bridge, moves)
        assertTrue { outContent.toString().contains("[O | X | O]\n[X | O | X]") }
    }

    @Test
    fun testPrintResult() {
        val bridge = listOf("U", "D", "U")
        val outContent = ByteArrayOutputStream().apply { System.setOut(PrintStream(this)) }
        outputView.printResult(bridge, true, 1)
        assertTrue { outContent.toString().contains("[O | X | O]\n[X | O | X]") }
    }
}