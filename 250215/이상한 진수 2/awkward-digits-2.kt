import kotlin.math.pow

fun main() {
    val input = readln().trim().toCharArray()
    val lastIdx = input.size - 1

    input
        .indexOfFirst { it == '0'}
        .takeIf { it != -1}
        ?.let { input[it] = '1' }
        ?: run { input[lastIdx] = '0' }

    var k = 2.0.pow(lastIdx).toInt()

    val ans = input.fold(0) { acc, digit ->
        (acc + (digit.digitToInt()) * k).also { k /= 2 }
    }

    println(ans)
}