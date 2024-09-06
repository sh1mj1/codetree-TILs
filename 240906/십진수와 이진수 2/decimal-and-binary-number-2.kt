val bits = readln().map { it.toInt() - 48}

var ansBits = mutableListOf<Int>()

fun main() {
    var decimal = bits.fold(0) { acc, bit ->
        acc * 2 + bit
    } * 17

    while(decimal != 0) {
        val remainder = decimal % 2
        ansBits.add(remainder)

        decimal = decimal / 2
    }
    for(i in ansBits.reversed()) {
        print(i)
    }

}