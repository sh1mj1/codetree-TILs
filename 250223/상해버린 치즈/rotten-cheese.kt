

fun main() {
    val (peopleCount, cheeseCount, eatCount, hurtCount) = readln().trim().split(" ").map(String::toInt)
    val eatHistories = List(eatCount) {
        val (personIdx, cheeseIdx, eatTime) = readln().trim().split(" ").map(String::toInt)
        EatHistory(personIdx, cheeseIdx, eatTime)
    }

    val hurtHistories = List(hurtCount) {
        val (personIdx, hurtTime) = readln().trim().split(" ").map(String::toInt)
        HurtHistory(personIdx, hurtTime)
    }

    val hurtPeople = hurtHistories.map { it.personIdx }.toMutableSet()

    eatHistories.forEach { eatHistory ->
        if (!hurtPeople.contains(eatHistory.personIdx)) {
            hurtPeople.add(eatHistory.personIdx)
        }
        if (hurtPeople.count() == peopleCount) {
            return@forEach
        }
    }
    println(hurtPeople.count())

}

data class EatHistory(
    val personIdx: Int,
    val cheeseIdx: Int,
    val eatTime: Int,
)

data class HurtHistory(
    val personIdx: Int,
    val hurtTime: Int,
)