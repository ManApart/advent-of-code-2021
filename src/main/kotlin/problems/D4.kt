package problems

import parseInputToStrings

fun main() {
    val input = parseInputToStrings(4, 1)
    val numbers = input.first().split(",").map { it.toInt() }
    val boards = input.subList(1, input.size).joinToString("\n").split("\n\n").map { Board(it.split("\n")) }
    val bingo = Bingo(boards, numbers)
    val (lastNumber, winner) = bingo.gameResult

    println(winner.getScore(lastNumber))
}

data class Square(val number: Int, var isMarked: Boolean = false)
data class Board(val squares: Map<Int, Map<Int, Square>>) {
    private val squareList = squares.values.flatMap { it.values }
    private val size = squares.keys.size

    constructor(rows: List<String>) : this(buildBoard(rows))

    fun mark(vararg numbers: Int) {
        squareList
            .filter { numbers.contains(it.number) }
            .map { it.isMarked = true }
    }

    fun isMarked(x: Int, y: Int): Boolean {
        return squares[y]!![x]!!.isMarked
    }

    fun getScore(lastNumber: Int = 1): Int {
        return squareList.filter { !it.isMarked }.sumOf { it.number } * lastNumber
    }

    fun isWinner(): Boolean {
        return rowComplete() || columnComplete()

    }

    private fun rowComplete() = (0 until size).any { y ->
        (0 until size).all { x ->
            isMarked(x, y)
        }
    }

    private fun columnComplete() = (0 until size).any { x ->
        (0 until size).all { y ->
            isMarked(x, y)
        }
    }
}

data class Bingo(val boards: List<Board>, val steps: List<Int>) {
    val gameResult = play()

    private fun play(): Pair<Int, Board> {
        steps.forEach { number ->
            boards.forEach { it.mark(number) }
            val winner = boards.firstOrNull { it.isWinner() }
            if (winner != null) return Pair(number, winner)
        }
        throw Exception("No winner found")
    }
}

private fun buildBoard(rows: List<String>): Map<Int, Map<Int, Square>> {
    return rows.filterNot { it.isBlank() }.mapIndexed { y, line ->
        y to buildRow(line)
    }.toMap()
}

private fun buildRow(line: String): Map<Int, Square> {
    val numbers = line.split(" ").map { it.trim() }.filterNot { it.isEmpty() }
    return numbers.indices.associateWith { x ->
        Square(numbers[x].toInt())
    }
}

