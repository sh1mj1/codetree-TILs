

fun main() {
    val n = readln().toInt()

    val queries = List(n) {
        val (number, strike, ball) = readln().trim().split(" ").map { it }
        Query(number, strike.toInt(), ball.toInt())
    }

    val range = 1 .. 9

    var count = 0

    for (i in range) {
        for (j in range) {
            if (i == j) continue
            for (k in range) {
                if (k == i || k == j) continue
                val candidate = listOf(i, j, k)

                if (queries.all { it.possible(candidate) }) {
                    count++
                }
            }
        }
    }
    println(count)
}

data class Query(
    val number: String,
    val strike: Int,
    val ball: Int,
) {
    val digits = number.map {
        it.digitToInt()
    }

    fun possible(target: List<Int>): Boolean {
        val strikeCount = (0 .. 2).count { digits[it] == target[it]}
        val ballCount = digits.toSet().intersect(target.toSet()).count() - strikeCount
    
        if (strikeCount == strike && ballCount == ball) return true
        return false
    }
}

