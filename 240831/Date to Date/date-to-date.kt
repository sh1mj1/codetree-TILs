val inputArr = readln().split(" ").map{it.toInt()}

val m1 = inputArr[0]
val d1 = inputArr[1]
val m2 = inputArr[2]
val d2 = inputArr[3]

val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    val x = d1
    var y = d2
    (m1-1 .. m2-2).forEach { m ->
        y += days[m]
    }

    println(y - x + 1)
}