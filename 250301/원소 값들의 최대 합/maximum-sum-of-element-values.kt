fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sequence = readln().split(" ").map { it.toInt() }

    var maxSum = 0

    for (startIndex in sequence.indices) {
        var currentIndex = startIndex
        var sum = 0

        repeat(m) {
            sum += sequence[currentIndex]
            currentIndex = sequence[currentIndex] - 1
        }

        maxSum = maxOf(maxSum, sum)
    }

    println(maxSum)
}