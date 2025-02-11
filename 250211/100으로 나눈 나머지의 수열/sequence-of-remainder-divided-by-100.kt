

fun main() {
    val n = readln().toInt()

    println(
        dfs(n)
    )
}

fun dfs(n: Int): Int {
    if (n == 1) return 2
    if (n == 2) return 4
    return (dfs(n - 1) * dfs(n - 2)) % 100
}