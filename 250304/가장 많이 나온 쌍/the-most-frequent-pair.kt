fun main() {
    val (n, m) = readln().trim().split(" ").map(String::toInt)

    val numberPairs = List(m) {
        readln().trim().split(" ").map(String::toInt).let {
            NumberPair(it[0], it[1])
        }
    }

    val maxCount = numberPairs.maxOf { pair ->
        numberPairs.count { it.equal(pair) }
    }

    println(maxCount)
}

data class NumberPair(
    val a: Int,
    val b: Int,
) {
    fun equal(other: NumberPair): Boolean {
        if (this == other) return true
        if (a == other.b && b == other.a) return true
        return false
    }
}
