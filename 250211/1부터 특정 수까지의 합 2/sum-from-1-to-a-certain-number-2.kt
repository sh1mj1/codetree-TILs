

fun main() {
    val n = readln().toInt()

    println(dfs(n))
}

fun dfs(n: Int): Int {
    if (n == 1) return n
    return n + dfs(n - 1)
}