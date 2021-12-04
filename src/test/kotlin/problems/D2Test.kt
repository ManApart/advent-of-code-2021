package problems

import parseInput
import kotlin.test.Test
import kotlin.test.assertEquals

class D2Test {

    private val input = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
    """.trimIndent()

    @Test
    fun getPosition() {
        val instructions = input.parseInput()
        assertEquals(Vector(15, 10), getPosition(instructions))
    }

    @Test
    fun getAimPosition() {
        val instructions = input.parseInput()
        assertEquals(Vector(15, 60, 10), getPositionAim(instructions))
    }

}