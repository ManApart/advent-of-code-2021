package problems

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class D1P2Test {

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
        val inputNumbers = input.split("\n").map { it.trim().toInt() }
        assertEquals(5, calcThreeIncreases(inputNumbers))
    }

    @Test
    fun sumTest() {
        val inputNumbers = listOf(3,0,1,1)
        assertEquals(0, calcThreeIncreases(inputNumbers))
    }


}