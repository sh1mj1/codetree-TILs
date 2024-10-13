val n = readln().toInt()
val numbers = readln().split(" ").map { it.toInt() }

fun main() {
    numbers.forEachIndexed{ idx, number ->
        if(idx % 2 == 0) {
            val midIdx = (idx+1) / 2
            print("${numbers[midIdx]} ")
        }
    }
}