import kotlin.math.pow

fun main() {
    var input = readln().trim().toCharArray()
    val lastIdx = input.size - 1

    var changed = false
    for (i in input.indices) {
        if (input[i] == '0') {
            input[i] = '1'
            changed = true
            break
        }
    }

    if (!changed) {
        input[lastIdx] = '0'
    }

    var k = 2.0.pow(lastIdx).toInt()

     val ans = input.fold(0) { acc, digit ->
        (acc + (digit - '0') * k).also { k /= 2 }
    }


    println(ans)
}