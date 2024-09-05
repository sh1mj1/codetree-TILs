val calendar = readln().split(" ").map {it.toInt()}

val m1 = calendar[0]
val d1 = calendar[1]
val m2 = calendar[2]
val d2 = calendar[3]

val inputDay = readln()

val dayOfMonth = intArrayOf(
    31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
) // 0 ~ 11

fun main() {
    val past = d1

    val future = (m1 until m2).sumOf { m ->
        dayOfMonth[m]
    } + d2

    val diff = future - past + 1

    val dayDiff: Int = when(inputDay) {
        "Mon" -> 0
        "Tue" -> 1
        "Wed" -> 2
        "Thu" -> 3
        "Fri" -> 4
        "Sat" -> 5
        "Sun" -> 6
        else -> 0
    }

    val realDiff = diff - dayDiff

    println(realDiff / 7 + 1)

    

}