val nkt = readln().trim().split(" ") // char arr

val n = nkt[0]
val k = nkt[1]
val t = nkt[2]

val words = List(n.toInt()) {
    readln().trim()
}

fun main() {
    val sorted = words.filter { it.startsWith(t) }
        .sorted()

    println(sorted[k.toInt() - 1])
}