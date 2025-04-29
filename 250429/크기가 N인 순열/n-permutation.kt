fun main() {
    val n = readLine()!!.toInt()
    // Please write your code here.
    val answer = mutableListOf<Int>()
    val visited = BooleanArray(n)

    fun choose(count: Int) {
        if (count == n) {
            answer.joinToString(" ").also(::println)
            return
        }

        for (i in 1 .. n) {
            if (visited[i - 1]) continue

            visited[i - 1] = true
            answer.add(i)
            choose(count + 1)

            visited[i - 1] = false
            answer.remove(i)
        }
    }
    choose(0)
}
