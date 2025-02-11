

fun main() {
    val n = readln().toInt()

    println(
        dfs(n, 0)
    )
}

fun dfs(n: Int, operationCount: Int): Int {
    if (n == 1) return operationCount

    if (n % 2 == 0) {
        return dfs(n / 2, operationCount + 1)
    }
    return dfs(n * 3 + 1, operationCount + 1)
}