val inputList = readln().split(" ").map { it.toInt() }

val m1 = inputList[0]
val d1 = inputList[1]
val m2 = inputList[2]
val d2 = inputList[3]

val daysForMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

fun main() {
    val past = (1 until m1).sumOf { month ->
        daysForMonth[month - 1]
    } + d1

    val now = (1 until m2).sumOf { month ->
        daysForMonth[month - 1]
    } + d2

    val diff = (now - past) % 7

    println(day(diff))
}

fun day(num: Int): String {
    when(num) {
        -6 -> return "Tue"
        -5 -> return "Wed"
        -4 -> return "Thu"
        -3 -> return "Fri"
        -2 -> return "Sat"
        -1 -> return "Sun"
        0 -> return "Mon"
        1 -> return "Tue"
        2 -> return "Wed"
        3 -> return "Thu"
        4 -> return "Fri"
        5 -> return "Sat"
        6 -> return "Sun"
        else -> error("invalid")
    }
}