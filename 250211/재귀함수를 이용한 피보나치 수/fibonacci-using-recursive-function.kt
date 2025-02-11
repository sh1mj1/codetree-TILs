fun main() {
    val n = readln().toInt()
    println(
        pibo(n)
    )
}

fun pibo(n: Int): Int {
    if (n == 1) {
        return 1
    }

    if (n == 2) {
        return 1
    }
    
    return pibo(n - 2) + pibo(n - 1)
}