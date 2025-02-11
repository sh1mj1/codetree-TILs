
fun main() {
    val n = readln().toInt()
    val elements = readln().trim().split(" ").map { it.toInt() }

    println(
        elements.dfs(0, 1)
    )
}

fun List<Int>.dfs(idx: Int, maxNumber: Int): Int {
    if (idx == this.size - 1) {
        return maxNumber
    }
    val max = if (this[idx] > maxNumber) {
        this[idx]
    } else {
        maxNumber
    }
    return dfs(idx + 1, max)
}