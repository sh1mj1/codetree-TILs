import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val maxIdx = n - 1

    val people = List(n) {
        readln().toInt()
    }
    val peopleSum = people.sumOf { it }

    var startIdx = 0
    val peopleCombinations: List<List<Int>> = List(n) {
        List(n) {
            people[startIdx].also { startIdx = increasedIdx(startIdx, maxIdx) }
        }.also { startIdx++ }
    }

    val answer = peopleCombinations.minOf { p ->
        p.withIndex().sumOf { (idx, value) -> idx * value }
    }

    println(answer)
}

fun increasedIdx(index: Int, maxIdx: Int): Int {
    if (index >= maxIdx) {
        return index - maxIdx
    } 
    return index + 1
}