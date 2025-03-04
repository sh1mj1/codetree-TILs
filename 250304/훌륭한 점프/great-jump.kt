fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val stones = readln().trim().split(" ").map(String::toInt).mapIndexed { i, num ->
        Stone(i, num)
    }

    val sortedStones = stones.sortedBy { it.num }

    for (stone in sortedStones) {
        val min = stone.num

        if (stones[0].num > min) continue

        val possibleNext = stones.filter { it.num <= min }

        if (
            possibleNext
                .windowed(2)
                .all { it[1].pos - it[0].pos <= k }
        ) {
            println(min)
            return
        }
    }
    
}

data class Stone(
    val pos: Int,
    val num: Int,
)
