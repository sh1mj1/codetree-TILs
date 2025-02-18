

fun main() {
    val n = readln().toInt()

    val queries = List(n) {
        val (number, strike, ball) = readln().trim().split(" ").map { it }
        Query(number, strike.toInt(), ball.toInt())
    }

    val range = 1 .. 9
    val allNumbers = allNumbers(range)

    allNumbers.count { numbers ->
        queries.all { query -> query.possible(numbers) }
    }.let(::println)
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

fun allNumbers(range: IntRange): List<List<Int>> =
    range.flatMap { i ->
        range.filter { it != i }.flatMap { j ->
            range.filter { it != i && it != j }.map { k ->
                listOf(i, j, k)
            }
        }
    }
