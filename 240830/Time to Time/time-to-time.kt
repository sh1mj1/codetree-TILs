val input = readln().split(" ").map{it.toInt()}.toIntArray()

val a = input[0]
val b = input[1]
val c = input[2]
val d = input[3]

fun main() {
    val past = a * 60 + b
    val future = c * 60 + d
    val ans = future - past
    println(ans)
}