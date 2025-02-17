import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val people = List(n) { readln().toInt() }


    val answer = (0 until n).minOf { startIdx ->
        people.withIndex().sumOf { (idx, peopleCount) -> 
            val targetIdx = (idx + startIdx) % n
            targetIdx * value
        }
    }

    println(answer)
}
