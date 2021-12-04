import java.io.File

fun parseInputToNumbers(day: Int, problem: Int): List<Int> {
    return parseInputToStrings(day, problem).map { it.toInt() }
}

fun parseInputToLongs(day: Int, problem: Int): List<Long> {
    return parseInputToStrings(day, problem).map { it.toLong() }
}

fun parseInputToStrings(day: Int, problem: Int): List<String> {
    return File("./input/d${day}p$problem.txt").readLines()
}

fun String.parseInput(): List<String> {
    return this.split("\n").map { it.trim() }
}

fun String.parseInputNumbers(): List<Int> {
    return this.parseInput().map { it.toInt() }
}