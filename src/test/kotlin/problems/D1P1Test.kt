package problems

import parseInputNumbers
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class D1P1Test {

    private val input = """
        199
        200
        208
        210
        200
        207
        240
        269
        260
        263
    """.trimIndent()

    @Test
    fun simpleTest() {
        val inputNumbers = input.parseInputNumbers()
        assertEquals(7, calcIncreases(inputNumbers))
    }

}