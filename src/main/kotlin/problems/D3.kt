package problems

import parseInputToStrings

fun main() {
    val input = parseInputToStrings(3, 1)
    val answer = getGammaRate(input) * getEpsilonRate(input)
    println(answer)

    val answer2 = getOxygenRate(input) * getCO2Rate(input)
    println(answer2)
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
    return counts.keys.sortedDescending().maxByOrNull { counts[it]!! } ?: 0
}

fun leastCommonBit(rows: List<String>, column: Int): Int {
    val counts = rows.map { it.toCharArray()[column].digitToInt() }.groupingBy { it }.eachCount()
    return counts.keys.sorted().minByOrNull { counts[it]!! } ?: 0
}

fun getOxygenRate(rows: List<String>, column: Int = 0): Int {
    if (rows.size == 1) return rows.first().toUInt(2).toInt()
    val max = mostCommonBit(rows, column)
    val filtered = rows.filter { it[column].digitToInt() == max }
    return getOxygenRate(filtered, column + 1)
}

fun getCO2Rate(rows: List<String>, column: Int = 0): Int {
    if (rows.size == 1) return rows.first().toUInt(2).toInt()
    val min = leastCommonBit(rows, column)
    val filtered = rows.filter { it[column].digitToInt() == min }
    return getCO2Rate(filtered, column + 1)
}