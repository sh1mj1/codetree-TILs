fun main() {
    val n = readln().toInt()
    val ranges = List(n) {
        readln().trim().split(" ").map(String::toInt).let { (start, end) -> Range(start, end) }
    }

    val result = (1..5_000).firstOrNull { initial ->
        generateSequence(initial * 2) { it * 2 }
            .take(n)
            .zip(ranges.asSequence())
            .all { (num, range) -> range.contains(num) }
    }

    println(result ?: "No valid number found")
}

data class Range(
    private val start: Int,
    private val end: Int,
) {
    fun contains(target: Int) = target in start..end
}