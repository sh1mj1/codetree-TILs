

fun main() {
    val (startNumber, endNumber) = readln().trim().split(" ").map(String::toInt)

    val interestingNumberCount = (startNumber .. endNumber).count(Int::isInteresting)

    println(interestingNumberCount)
}

fun Int.isInteresting(): Boolean {
    val digitCounts = this.toString().groupingBy { it }.eachCount()

    return digitCounts.size == 2 && digitCounts.values.contains(this.toString().length - 1)

}