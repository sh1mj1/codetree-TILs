import kotlin.math.max

fun main() {
    val count = readln().toInt()
    val characters = readln()

    var maxCount = 0

    var sIdx = 0
    while (sIdx < count) {
        val thisStartIdx = sIdx

        var otherIdx = characters.indexOfLast(from = count - 1,to = sIdx + 1, characters[sIdx])

        if (otherIdx == -1) {
            sIdx++
            continue
        }

        val thisOtherIdx = otherIdx

        var tempCount = 0

        while (otherIdx != -1) {
            sIdx = thisStartIdx
            tempCount++; sIdx++; otherIdx++

            while (sIdx < count && otherIdx < count && characters[sIdx] == characters[otherIdx]) {
                tempCount++; sIdx++; otherIdx++
            }
            otherIdx = characters.indexOfLast(from = thisOtherIdx - 1,to = thisStartIdx + 1, characters[thisStartIdx])
        }

        maxCount = max(maxCount, tempCount)
    }

    println(maxCount + 1)
}

private fun String.indexOfLast(
    from: Int,
    to: Int,
    target: Char,
): Int {
    for (i in from downTo to) {
        if (this[i] == target) {
            return i
        }
    }
    return -1
}