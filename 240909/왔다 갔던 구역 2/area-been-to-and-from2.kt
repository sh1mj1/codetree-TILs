var ans = 0
val n = readln().toInt()

val sections = IntArray(2_002) { 0 }
var nowPoint = 1_000

fun main() {

    repeat(n) {
        val cmd = readln().split(" ")
        val count = cmd[0].toInt()
        val direction = cmd[1]

        when(direction) {
            "L" -> {
                repeat(count) {
                    sections[nowPoint--]++
                    if (sections[nowPoint + 1] == 2 ) {
                        ans++
                    }
                }
            }
            "R" -> {
                repeat(count) {
                    sections[++nowPoint]++
                    if (sections[nowPoint] == 2) {
                        ans++
                    }
                }
            }
            else -> {}
        }
    }
    println(ans)

}