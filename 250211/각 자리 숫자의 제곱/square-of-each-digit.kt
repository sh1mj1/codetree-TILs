fun main() {
    val n = readln().toInt()
    println(dfs(n))
}

fun dfs(n: Int): Int {
    if (n < 10) return n * n
    val remainder = n % 10
    return remainder * remainder + dfs(n / 10)
}