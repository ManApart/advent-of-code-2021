package problems

fun calcIncreases(measures: List<Int>): Int {
    return measures.windowed(2).map { window ->
        println("Comparing ${window.joinToString()}")
        if (window.first() < window.last()) 1 else 0
    }.sum()
}

fun calcThreeIncreases(measures: List<Int>): Int {
    var previous = 0
    return measures.windowed(3).map { window ->
        val current = window.sum()
        println("Comparing $previous to $current")
        (if (current > previous) 1 else 0).also { previous = current }
    }.sum() -1
    //-1 to ignore the first sum
}