val dividers = listOf(2, 3, 5, 7)

fun main() {
    val n = readln().toInt()
    val numbers = readln().trim().split(" ").map { it.toInt() }
    
    val result = dfs(0, numbers)
    val answer = 2 * 3 * 5 * 7 * result.reduce { acc, value ->
        acc * value
    }

    println(
        answer
    )
}


fun dfs(index: Int, numbers: List<Int>): List<Int> {
    if (index == 4) {
        return numbers
    }
    return dfs(
        index + 1,
        numbers.map {
            quotientOrSame(dividers[index], it)
        }
    )
}


fun quotientOrSame(divider: Int, num: Int): Int {
    if (num % divider == 0) {
        return num / divider
    }
    return num
}