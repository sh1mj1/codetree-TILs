val binarySeq = readln().map {it.toInt() - 48}

var ans = 0

fun main() {
    if(binarySeq.size == 1) {
        println(binarySeq[0])
        return
    }
    binarySeq.forEach { 
        ans = 2 * it + 1
    }
    println(ans)
}