package problems

import parseInputToStrings

fun main() {
    val input = parseInputToStrings(3, 1)
    val answer = getGammaRate(input) * getEpsilonRate(input)
    println(answer)
}

fun getGammaRate(rows: List<String>): Int {
    val columnCount = rows.first().length - 1
    val bits = (0..columnCount).map { col -> mostCommonBit(rows, col) }.joinToString("")
    return bits.toUInt(2).toInt()
}

fun getEpsilonRate(rows: List<String>): Int {
    val columnCount = rows.first().length - 1
    val bits = (0..columnCount).map { col -> leastCommonBit(rows, col) }.joinToString("")
    return bits.toUInt(2).toInt()
}

fun mostCommonBit(rows: List<String>, column: Int): Int {
    val counts = rows.map { it.toCharArray()[column].digitToInt() }.groupingBy { it }.eachCount()
    return counts.keys.maxByOrNull { counts[it]!! } ?: 0
}


fun leastCommonBit(rows: List<String>, column: Int): Int {
    val counts = rows.map { it.toCharArray()[column].digitToInt() }.groupingBy { it }.eachCount()
    return counts.keys.minByOrNull { counts[it]!! } ?: 0
}