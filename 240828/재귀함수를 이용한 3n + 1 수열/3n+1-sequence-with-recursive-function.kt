val n = readln().toInt()

var count = 0

fun f(num: Int): Int {
    if(num == 1) {
        return count
    }

    count++

    if(num % 2 == 0) {
        val quotient = num / 2   
        return f(quotient)
    }

    val next = num * 3 + 1
    return f(next)
}

fun main() {
    println(f(n))
}