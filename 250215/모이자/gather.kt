import kotlin.math.abs

val n = readln().toInt()
val people = readln().trim().split(" ").map(String::toInt)

fun main() {

    println(
        people.withIndex().minOf { (targetIdx, _) -> 
            people.withIndex().sumOf { (currentIdx, currentPeopleCount) -> 
                abs(targetIdx - currentIdx) * currentPeopleCount
            }
        }
    )
}
