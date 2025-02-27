fun main() {
    val (a, b, c) = readln().trim().split(" ").map(String::toInt)
    val aCountMax = c / a

    val maxSum = (0 .. aCountMax).maxOf { aCount ->
        val aSum = aCount * a
        val bCountMax = (c - aSum) / b
        aSum + b * bCountMax
    }
    
    println(maxSum)
}
