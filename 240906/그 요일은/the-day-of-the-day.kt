val calendar = readln().split(" ").map {it.toInt()}

val m1 = calendar[0]
val d1 = calendar[1]
val m2 = calendar[2]
val d2 = calendar[3]

val inputDay = readln()

val dayOfMonth = intArrayOf(
    31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
) // 0 ~ 11

val seqOfWeek = mapOf(
    "Mon" to 0,
    "Tue" to 1,
    "Wed" to 2,
    "Thu" to 3,
    "Fri" to 4,
    "Sat" to 5,
    "Sun" to 6,
)


fun main() {
    val past = d1
    val future = (m1 until m2).sumOf { m ->
        dayOfMonth[m]
    } + d2

    val diff = future - past

    val targetDay = seqOfWeek[inputDay] ?: throw error("invalid inputDay")

    var lastDay = diff % 7

    var ans = 0

    if(lastDay > 0) {
        ans = (diff + 1 - targetDay) / 7
    }
    println(ans)
}