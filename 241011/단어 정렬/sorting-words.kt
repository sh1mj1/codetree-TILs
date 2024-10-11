fun main() {
    val n = readln().toInt()

    val words = List(n) {
        readln().trim()
    }

    (words.sorted()).forEach {
        println(it)
    }
}