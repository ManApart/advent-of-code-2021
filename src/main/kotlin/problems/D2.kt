package problems

import parseInputToStrings

data class Vector(var x: Int = 0, var y: Int = 0) {
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }
    fun multiplyCoords(): Int {
        return x*y
    }
}

fun main(){
    val position = getPosition(parseInputToStrings(2,1))
    println(position.multiplyCoords())
}

fun getPosition(instructions: List<String>): Vector {
    return instructions.map { parseVector(it) }.sum()
}

fun parseVector(line: String): Vector {
    val parts = line.split(" ")
    val direction = parts.first()
    val amount = parts.last().toInt()
    return when(direction){
        "forward" -> Vector(amount)
        "up" -> Vector(0, -amount)
        "down" -> Vector(0, amount)
        else -> throw Exception("Unknown instruction $line")
    }
}

fun List<Vector>.sum():Vector{
    return Vector(this.sumOf { it.x }, this.sumOf { it.y })
}