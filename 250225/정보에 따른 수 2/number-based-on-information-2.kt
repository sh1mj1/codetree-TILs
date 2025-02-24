import kotlin.math.abs

fun main() {
    val (alphabetCount, startPosition, endPosition) = readln().trim().split(" ").map(String::toInt)
    val alphabets = List(alphabetCount) {
        readln().trim().split(" ").let { Alphabet(it[0], it[1].toInt()) }
    }

    val specialPositionCount = (startPosition .. endPosition).count { position ->
        val closestSDistance = alphabets
            .filter { it.letter == "S" }
            .minOf { abs(it.position - position) }

        val closestNDistance = alphabets
            .filter { it.letter == "N" }
            .minOf { abs(it.position - position) }
        
        closestSDistance <= closestNDistance
    }

    println(specialPositionCount)
}

data class Alphabet(
    val letter: String,
    val position: Int,
)
