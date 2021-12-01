import problems.calcIncreases
import java.io.File

fun main(){
    println(calcIncreases(parseInputToNumbers(1, 1)))
}

private fun parseInputToNumbers(day: Int, problem: Int): List<Int> {
    return parseInputToStrings(day, problem).map { it.toInt() }
}

private fun parseInputToLongs(day: Int, problem: Int): List<Long> {
    return parseInputToStrings(day, problem).map { it.toLong() }
}

private fun parseInputToStrings(day: Int, problem: Int): List<String> {
    return File("./input/d${day}p$problem.txt").readLines()
}