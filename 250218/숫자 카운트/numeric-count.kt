

fun main() {
    val n = readln().toInt()

    val queries = List(n) {
        val (number, strike, ball) = readln().trim().split(" ").map { it }
        Query(
            number,
            strike.toInt(),
            ball.toInt(),
        )
    }

    val allNumbers = sequence {
        for (i in 1..9) {
            for (j in 1..9) {
                if (j != i) {
                    for (k in 1..9) {
                        if (k != j && k != i) {
                            yield(listOf(i, j, k))
                        }
                    }
                }
            }
        }
    }

    allNumbers.count { numbers ->
        queries.all { query -> 
            query.possible(numbers)
        }
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
        var strikeCount = 0
        var ballCount = 0

        for (i in 0 .. 2) {
            if (digits[i] == target[i]) strikeCount++
        }
        ballCount = digits.intersect(target).count() - strikeCount
    
        if (strikeCount == strike && ballCount == ball) return true

        return false
    }
}