fun main() {
    val (n, m) = readln().trim().split(" ").map(String::toInt)

    val numbersSet = List(m) {
        readln().trim().split(" ").map(String::toInt).let {
            Numbers(setOf(it[0], it[1]))
        }
    }

    val numbersCounts = mutableMapOf<Numbers, Int>()
    numbersSet.forEach {
        numbersCounts[it] = numbersCounts.getOrDefault(it, 0) + 1
    }
    println(numbersCounts.values.maxOf { it } )
}

data class Numbers(
    private val _values: Set<Int>
) {
    val values = _values.sorted()
}
