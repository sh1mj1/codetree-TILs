val numbers = readln().split(" ").map{it.toInt()}
val a = numbers[0] // a 진수
val b = numbers[1] // b 진수

val n = readln().map{ it.toInt() - 48 } // 수 0 ~ 1_000_000_000

fun List<Int>.toDecimal(): Int {
    var result = 0
    for(digit in n) {
        result = result * a + digit
    }
    return result
}


fun Int.toB(): List<Int> {
    val li = mutableListOf<Int>()
    var x = this // 나누는 수
    while(x != 0) {
        val remainder = x % b
        li.add(remainder)
        x = x / b
    }
    return li.reversed()
}

fun main() {
    println(n.toDecimal().toB().joinToString(""))
}