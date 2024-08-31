val input = readln().split(" ").map{ it.toInt()}

val day = input[0]
val hour = input[1]
val min = input[2]

val pastDay = 11
val pastHour = 11
val pastMin = 11

fun main() {
    if(day < pastDay || hour < pastHour || min < pastMin) {
        println("-1")
        return
    }

    val x = min + hour * 60 + day * 24 * 60
    val y = pastMin + pastHour * 60 + pastDay  * 24 * 60

    println(x - y)

}