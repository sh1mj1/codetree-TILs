fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    // Please write your code here.\
    val answer = mutableListOf<Int>()
    
    val numbers = (1 .. k).toList()

    fun printAnswer() {
        answer.forEach { print(it.toString() + " ") }
        println()
    }

    fun choose(depth: Int) {
        if (depth >= n) {
            printAnswer()
            return
        }
        
        for (num in numbers) {
            if (depth >= 2) {
                val lastIdx = answer.size - 1
                if (num == answer[lastIdx] && num == answer[lastIdx - 1]) continue
            }
            answer.add(num)
            choose(depth + 1)
            if (answer.isNotEmpty()) answer.removeLast()
        }
    }
    choose(0)
}