import kotlin.math.abs
import kotlin.math.min

fun main() {
    val abilities = readln().trim().split(" ").map(String::toInt)
    val totalSum = abilities.sum()
    val size = abilities.size




    var answer = Int.MAX_VALUE
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            for (k in j + 1 until size) {
                val teamSum = abilities[i] + abilities[j] + abilities[k]
                val otherTeamSum = totalSum - teamSum

                answer = min(answer, abs(teamSum - otherTeamSum))
            }
        }
    }
    println(answer)
}