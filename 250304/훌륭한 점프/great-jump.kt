fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val stones = readln().trim().split(" ").mapIndexed { i, num -> Stone(i, num.toInt()) }

    stones
        .sortedBy { it.num }
        .firstOrNull { minStone ->
            if (stones.first().num > minStone.num || stones.last().num > minStone.num) 
                return@firstOrNull false

            val possibleNext = stones.filter { it.num <= minStone.num }
            possibleNext
                .windowed(2)
                .all { (a, b) -> b.pos - a.pos <= k }
        }
        ?.num
        ?.let(::println)
}

data class Stone(
    val pos: Int,
    val num: Int,
)