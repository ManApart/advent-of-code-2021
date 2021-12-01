package problems

fun calcIncreases(measures: List<Int>): Int {
    return measures.windowed(2).map { window ->
        println("Comparing ${window.joinToString()}")
        if (window.first() < window.last()) 1 else 0
    }.sum()
}