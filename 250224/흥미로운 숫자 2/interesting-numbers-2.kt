

fun main() {
    val (startNumber, endNumber) = readln().trim().split(" ").map(String::toInt)

    val interestingNumberCount = (startNumber .. endNumber).count(Int::isInteresting)
    
    println(interestingNumberCount)
}

private fun Int.isInteresting(): Boolean {
    val digits = this.toString().map { it.digitToInt() }

    val iteratedDigit: Int

    if (digits[0] == digits[1]) {
        iteratedDigit = digits[0]
    } else if (digits[1] == digits[2]) {
        iteratedDigit = digits[1]
    } else {
        iteratedDigit = digits[0]
    }

    return digits.count { it != iteratedDigit } == 1
}