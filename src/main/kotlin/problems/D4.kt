package problems

data class Square(val number: Int, var isMarked: Boolean = false)
data class Board(val squares: Map<Int, Map<Int, Square>>) {
    constructor(rows: List<String>) : this(buildBoard(rows))

    fun isWinner(): Boolean {
        return false
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

fun main() {

}
