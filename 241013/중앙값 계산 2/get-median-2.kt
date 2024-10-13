val n = readln().toInt()
val numbers = readln().split(" ").map { it.toInt() }

fun main() {
    val sortedNumbers = number.sorted()
    sortedNumbers.forEachIndexed{ idx, number ->
        if(idx % 2 == 0) {
            val midIdx = (idx+1) / 2
            print("${sortedNumbers[midIdx]} ")
        }
    }
}