fun main() {
    val tryCount = readln().toInt()
    val tries = List(tryCount) {
        readln().trim().split(" ").map(String::toInt).let { Try(it[0], it[1], it[2]) }
    }

    val maxPoints = (1 .. 3).toList().maxOf { startPosition ->
        tries.fold(startPosition to 0) { (currentPosition, count), thisTry -> 
            val newPosition = when (currentPosition) {
                thisTry.mix1 -> thisTry.mix2
                thisTry.mix2 -> thisTry.mix1
                else -> currentPosition
            }

            val newCount = if (newPosition == thisTry.choose) 
                1 else 0

            newPosition to (count + newCount)
        }.second
    }

    println(maxPoints)
}

data class Try(
    val mix1: Int,
    val mix2: Int,
    val choose: Int,
)

