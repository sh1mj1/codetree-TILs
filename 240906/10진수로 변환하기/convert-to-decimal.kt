val binarySeq = readln().map {it.toInt() - 48}

var ans = 0

fun main() {
    binarySeq.forEach { 
        ans = 2 * it + 1
    }
    println(ans)
}