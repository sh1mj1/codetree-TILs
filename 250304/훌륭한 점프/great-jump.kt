import java.util.*

fun main() {
    val (n, k) = readln().trim().split(" ").map(String::toInt)
    val stones = readln().trim().split(" ").map(String::toInt)

    // BFS를 위한 큐
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(0 to stones[0]) // 시작 위치 (index, 해당 돌의 값)

    val visited = BooleanArray(n) { false }
    visited[0] = true

    var minMaxValue = stones[0] // 거쳐간 돌들의 값 중 최댓값의 최소값

    while (queue.isNotEmpty()) {
        val (currentIndex, currentMax) = queue.poll()
        minMaxValue = minOf(minMaxValue, currentMax)

        if (currentIndex == n - 1) {
            println(minMaxValue)
            return
        }

        for (nextIndex in currentIndex + 1 until n) {
            if (nextIndex - currentIndex > k) break
            if (!visited[nextIndex]) {
                visited[nextIndex] = true
                queue.add(nextIndex to maxOf(currentMax, stones[nextIndex]))
            }
        }
    }
}