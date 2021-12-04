package problems

import parseInput
import kotlin.test.Test
import kotlin.test.assertEquals

class D3P2Test {

    private val input = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()

    @Test
    fun oxygenRate() {
        val lines = input.parseInput()

        assertEquals(23, getOxygenRate(lines))
    }

    @Test
    fun co2Rate() {
        val lines = input.parseInput()

        assertEquals(10, getCO2Rate(lines))
    }


}