val binarySeq = readln().map {it.toInt() - 48}

fun main() {
    val ans = binarySeq.fold(0) { acc, bit -> acc * 2 + bit }
    println(ans)
}