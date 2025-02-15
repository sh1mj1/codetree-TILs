import kotlin.math.abs

val n = readln().toInt()
val people = readln().trim().split(" ").map(String::toInt)

fun main() {
    var answer = Int.MAX_VALUE

    for (i in people.indices) {
        var sum = 0

        for (j in people.indices) {
            sum = sum + abs(i - j) * people[j]
        }
        
        if (answer >= sum) {
            answer = sum
        }
    }

    println(answer)
}