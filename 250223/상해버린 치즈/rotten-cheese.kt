import kotlin.math.max

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

    val possibleBadCheese = MutableList(cheeseCount) { it + 1 }

    hurtHistories.forEach { hurtHistory ->
        val tempPossibleBadCheese = eatHistories.filter {
            it.eatTime < hurtHistory.hurtTime && it.personIdx == hurtHistory.personIdx
        }.map {
            it.cheeseIdx
        }

        val goodCheese = possibleBadCheese - tempPossibleBadCheese
        possibleBadCheese.removeAll(goodCheese)
    }

    var maxHurtPeopleCount = 0

    for (badCheese in possibleBadCheese) {
        val tempMaxHurtPeopleCount = eatHistories
            .filter { eatHistory -> eatHistory.cheeseIdx == badCheese }
            .map { it.personIdx }
            .toSet()
            .count()

        maxHurtPeopleCount = max(tempMaxHurtPeopleCount, maxHurtPeopleCount)
    }

    println(
        maxHurtPeopleCount
    )
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