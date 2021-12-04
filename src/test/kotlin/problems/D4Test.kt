package problems

import parseInput
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class D4Test {
    private val baseBoardInput = """
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19
        """.parseInput()

    @Test
    fun buildBoard() {
        val expected = Board(
            mapOf(
                0 to mapOf(
                    0 to Square(22),
                    1 to Square(13),
                    2 to Square(17),
                    3 to Square(11),
                    4 to Square(0)
                ),
                1 to mapOf(
                    0 to Square(8),
                    1 to Square(2),
                    2 to Square(23),
                    3 to Square(4),
                    4 to Square(24)
                ),
                2 to mapOf(
                    0 to Square(21),
                    1 to Square(9),
                    2 to Square(14),
                    3 to Square(16),
                    4 to Square(7)
                ),
                3 to mapOf(
                    0 to Square(6),
                    1 to Square(10),
                    2 to Square(3),
                    3 to Square(18),
                    4 to Square(5)
                ),
                4 to mapOf(
                    0 to Square(1),
                    1 to Square(12),
                    2 to Square(20),
                    3 to Square(15),
                    4 to Square(19)
                ),
            )
        )

        assertEquals(expected, Board(baseBoardInput))
    }

    @Test
    fun markNumber() {
        val board = Board(baseBoardInput)

        board.mark(20)
        board.mark(22)
        board.mark(1)
        board.mark(0)

        assertTrue(board.isMarked(0,0))
        assertTrue(board.isMarked(4,0))
        assertTrue(board.isMarked(0,4))
        assertFalse(board.isMarked(1,0))
    }

    @Test
    fun isWinnerHorizontal() {
        val board = Board(baseBoardInput)
        assertFalse(board.isWinner())

        with(board) {
            mark(8)
            mark(2)
            mark(23)
            mark(4)
            mark(24)
        }

        assertTrue(board.isWinner())
    }

    @Test
    fun isWinnerVertical() {
        val board = Board(baseBoardInput)
        assertFalse(board.isWinner())

        with(board) {
            mark(13)
            mark(2)
            mark(9)
            mark(10)
            mark(12)
        }
        assertTrue(board.isWinner())
    }

    @Test
    fun getScore() {
        val board = Board(baseBoardInput)
        assertFalse(board.isWinner())

        with(board) {
            mark(13)
            mark(2)
            mark(9)
            mark(10)
            mark(12)
        }
        assertTrue(board.isWinner())
        assertEquals(254, board.getScore())
    }

}