package problems

fun main() {

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

    fun getScore(lastNumber: Int = 1): Int{
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

