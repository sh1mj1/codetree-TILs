fun main() {
    val n = readln().toInt()
    val elements = readln().split(" ").map { it.toInt() }

    val asending = elements.sorted()
    val descending = elements.sortedDescending()

    asending.forEach{
        print("$it ")
    }
    println()
    descending.forEach {
        print("$it ")
    }
}