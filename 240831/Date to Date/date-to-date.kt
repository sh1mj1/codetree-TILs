val inputArr = readln().split(" ").map{it.toInt()}

val m1 = inputArr[0]
val d1 = inputArr[1]
val m2 = inputArr[2]
val d2 = inputArr[3]

val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    val x = d1
    val y = (m1 until m2).sumOf { month ->
        days[month -1]
    } + d2

    println(y - x + 1)
}

/*
    val totalDays = (m1 until m2).sumOf { days[it - 1] } + d2 - d1 + 1

    println(totalDays)
*/