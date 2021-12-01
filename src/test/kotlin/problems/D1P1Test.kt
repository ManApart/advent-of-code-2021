package problems

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
        val inputNumbers = input.split("\n").map { it.trim().toInt() }
        assertEquals(7, calcIncreases(inputNumbers))
    }

    @Test
    fun fullInput() {
        val inputNumbers = File("./input/d1p1.txt").readLines().map { it.trim().toInt() }
        assertEquals(7, calcIncreases(inputNumbers))
    }

}