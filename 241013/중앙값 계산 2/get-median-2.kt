val n = readln().toInt()
val numbers = readln().split(" ").map { it.toInt() }

fun main() {
    numbers.forEachIndexed{ idx, number ->
        if(idx % 2 == 0) {
            val midIdx = (idx+1) / 2
            val sorted = numbers.slice(0..idx).sorted()
            print("${sorted[midIdx]} ")
        }
    }
}