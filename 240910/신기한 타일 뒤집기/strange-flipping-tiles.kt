var ans = 0
val n = readln().toInt()

val sections = List(200_002) { Section(0) }
var nowPoint = 100_000

var mostRightPoint = 100_000
var mostLeftPoint = 100_000

fun main() {

    repeat(n) {
        val cmd = readln().split(" ")
        val count = cmd[0].toInt()
        val direction = cmd[1]

        when(direction) {
            "L" -> {
                for(i in 0 until count) {
                    val nowSection = sections[nowPoint]
    // 0: gray, 1: black, 2: white
                    nowSection.recent = 2

                    if(i == count-1) {
                        break
                    }
                    nowPoint--
                }
            }
            "R" -> {
                for(i in 0 until count) {
                    val nowSection = sections[nowPoint]
    // 0: gray, 1: black, 2: white
                    nowSection.recent = 1
                    if(i == count-1) {
                        break
                    }
                    nowPoint++
                }
            }
            else -> {}
        }
    }

    var white = 0
    var black = 0
    for(section in sections) {
        when(section.recent) {
            1 -> {black++}
            2 -> {white++}
            else -> {}
        }
    }
    println("$white $black")
}

data class Section(
    // 0: gray, 1: black, 2: white
    var recent: Int
) {
    fun isBlack(): Boolean = recent == 1

    fun isWhite(): Boolean = recent == 2

    fun isGray(): Boolean = recent == 0

}