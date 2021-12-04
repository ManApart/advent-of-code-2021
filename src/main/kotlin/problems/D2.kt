package problems

import parseInputToStrings

data class Vector(val x: Int = 0, val y: Int = 0, val aim: Int = 0) {
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y, aim + other.aim)
    }

    fun multiplyCoords(): Int {
        return x * y
    }
}

fun main() {
    val position = getPosition(parseInputToStrings(2, 1))
    println(position.multiplyCoords())

    val position2 = getPositionAim(parseInputToStrings(2, 1))
    println(position2.multiplyCoords())
}

fun getPosition(instructions: List<String>): Vector {
    return instructions.map { parseVector(it) }.sum()
}

fun parseVector(line: String): Vector {
    val parts = line.split(" ")
    val direction = parts.first()
    val amount = parts.last().toInt()
    return when (direction) {
        "forward" -> Vector(amount)
        "up" -> Vector(0, -amount)
        "down" -> Vector(0, amount)
        else -> throw Exception("Unknown instruction $line")
    }
}

fun getPositionAim(instructions: List<String>): Vector {
    return instructions
        .map { parseVectorAim(it) }
        .fold(Vector()) { acc, instruction ->
//            println(acc)
            instruction(acc)
        }
}

fun parseVectorAim(line: String): (Vector) -> Vector {
    val parts = line.split(" ")
    val direction = parts.first()
    val amount = parts.last().toInt()
    return when (direction) {
        "forward" -> { source -> source.copy(x = source.x + amount, y = source.y + (source.aim * amount)) }
        "up" -> { source -> source.copy(aim = source.aim - amount) }
        "down" -> { source -> source.copy(aim = source.aim + amount) }
        else -> throw Exception("Unknown instruction $line")
    }
}

fun List<Vector>.sum(): Vector {
    return Vector(this.sumOf { it.x }, this.sumOf { it.y })
}