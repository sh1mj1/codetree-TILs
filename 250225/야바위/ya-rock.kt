fun main() {
    val tryCount = readln().toInt()
    val tries = List(tryCount) {
        readln().trim().split(" ").map(String::toInt).let { Try(it[0], it[1], it[2]) }
    }

    val maxPoints = listOf<Int>(1, 2, 3).maxOf { startPos ->
        var stonePosition = startPos

        tries.count { thisTry ->
            when (stonePosition) {
                thisTry.mix1 -> stonePosition = thisTry.mix2
                thisTry.mix2 -> stonePosition = thisTry.mix1
                else -> {}
            }

            stonePosition == thisTry.choose
        }
    }

    println(maxPoints)
}

data class Try(
    val mix1: Int,
    val mix2: Int,
    val choose: Int,
)
