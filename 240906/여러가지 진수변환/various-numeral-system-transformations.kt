val input = readln().split(" ").map { it.toInt() }

var N = input[0] // 정수
val B = input[1] // 진수 4 or 8

val ansBits = mutableListOf<Int>()

fun main() {
    while(N != 0) {
        val remainder = N % B
        N = N / B
        ansBits.add(remainder)
    }

    for(i in ansBits.reversed()) {
        print(i)
    }
}