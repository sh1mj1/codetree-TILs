import kotlin.math.abs

fun main() {
    val numberCount = readln().toInt()
    val numbers = readln().trim().split(" ").map(String::toInt)
    val idxRange = (0 until numberCount)

    val minDiffSum = idxRange.minOf { idx ->
        val multipliedNumbers = numbers.mapIndexed { multipliedIdx, number ->
            if (multipliedIdx == idx) number * 2
            else number
        }
        idxRange.minOf { removedIdx ->
            val removedNumbers = multipliedNumbers.filterIndexed { idx, number -> idx != removedIdx }    
            removedNumbers.windowed(2).sumOf { abs(it[0] - it[1]) }
        }
    }

    println(minDiffSum)
}

