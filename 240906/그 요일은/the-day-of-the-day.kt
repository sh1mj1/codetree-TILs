val calendar = readln().split(" ").map {it.toInt()}

val m1 = calendar[0]
val d1 = calendar[1]
val m2 = calendar[2]
val d2 = calendar[3]

val inputDay = readln()

val dayOfMonth = intArrayOf(
    31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
) // 0 ~ 11

val seqOfWeek = intArrayOf(
    0, 1, 2, 3, 4, 5, 6
) // Mon ~ Sun

fun main() {
    val past = d1

    val future = (m1 until m2).sumOf { m ->
        dayOfMonth[m]
    } + d2

    val diff = future - past

    val dayOfFuture = diff % 7

    if(dayOfFuture == 0){
        println(diff / 7 + 1)
        return
    }
    println(diff / 7)
}