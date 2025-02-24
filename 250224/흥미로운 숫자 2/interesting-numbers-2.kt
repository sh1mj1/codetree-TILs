

fun main() {
    val (startNumber, endNumber) = readln().trim().split(" ").map(String::toInt)

    val interestingNumberCount = (startNumber .. endNumber).count(Int::isInteresting)

    println(interestingNumberCount)
}

fun Int.isInteresting(): Boolean {
    val digits = this.toString().map { it }

    return digits.toSet().size == 2 && 
        digits.any { digit -> digits.count { it == digit } == digits.size - 1 
    }
}