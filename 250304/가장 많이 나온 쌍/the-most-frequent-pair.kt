fun main() {
    val (n, m) = readln().trim().split(" ").map(String::toInt)

    val numbersSet = List(m) {
        readln().trim().split(" ").map(String::toInt).let {
            Numbers(setOf(it[0], it[1]))
        }
    }

    val numbersCounts = mutableMapOf<Numbers, Int>()

    for (numbers in numbersSet) {
        if (numbersCounts[numbers] == null) {
            numbersCounts[numbers] = 1
            continue
        }
        numbersCounts[numbers] = numbersCounts[numbers]!! + 1
    }

    val maxCount = numbersSet.maxOf { pair ->
        numbersSet.count { it.values == pair.values }
    }

    println(maxCount)
}

data class Numbers(
    private val _values: Set<Int>
) {
    val values = _values.sorted()
}

