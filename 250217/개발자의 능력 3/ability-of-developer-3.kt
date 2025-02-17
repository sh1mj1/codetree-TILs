import kotlin.math.abs

fun main() {
    val abilities = readln().trim().split(" ").map(String::toInt)
    val totalSum = abilities.sum()
    val size = abilities.size

    val answer = (0 until size - 2).minOf { i ->
        (i + 1 until size - 1).minOf { j ->
            (j + 1 until size).minOf { k ->
                val teamSum = abilities[i] + abilities[j] + abilities[k]
                val otherTeamSum = totalSum - teamSum
                abs(teamSum - otherTeamSum)
            }
        }
    }

    println(answer)
}