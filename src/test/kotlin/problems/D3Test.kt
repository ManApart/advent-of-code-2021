package problems

import parseInput
import kotlin.test.Test
import kotlin.test.assertEquals

class D3Test {

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
    fun mostCommonBit() {
        val lines = input.parseInput()

        assertEquals(1, mostCommonBit(lines, 0))
        assertEquals(0, mostCommonBit(lines, 1))
        assertEquals(1, mostCommonBit(lines, 2))
        assertEquals(1, mostCommonBit(lines, 3))
        assertEquals(0, mostCommonBit(lines, 4))
    }

    @Test
    fun leastCommonBit() {
        val lines = input.parseInput()

        assertEquals(0, leastCommonBit(lines, 0))
        assertEquals(1, leastCommonBit(lines, 1))
        assertEquals(0, leastCommonBit(lines, 2))
        assertEquals(0, leastCommonBit(lines, 3))
        assertEquals(1, leastCommonBit(lines, 4))
    }

    @Test
    fun defaultCommon() {
        val lines = listOf("10110", "10111")
        assertEquals(1, mostCommonBit(lines, 4))
        assertEquals(0, leastCommonBit(lines, 4))
    }

    @Test
    fun gammaRate() {
        val lines = input.parseInput()
        assertEquals(22, getGammaRate(lines))
    }

    @Test
    fun epsilonRate() {
        val lines = input.parseInput()
        assertEquals(9, getEpsilonRate(lines))
    }

}