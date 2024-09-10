var ans = 0
val n = readln().toInt()

val sections = MutableList(200_002) { Section(Color.GRAY) }
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
                    sections[nowPoint] = sections[nowPoint].flipLeft()

                    if(i == count-1) {
                        break
                    }
                    nowPoint--
                }
            }
            "R" -> {
                for(i in 0 until count) {
                    sections[nowPoint] = sections[nowPoint].flipRight()

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
            Color.BLACK -> {black++}
            Color.WHITE -> {white++}
            Color.GRAY -> {}
        }
    }
    println("$white $black")
}

data class Section(
    val recent: Color
) {
    fun flipLeft(): Section = Section(recent.flipLeft())

    fun flipRight(): Section = Section(recent.flipRight())
}

enum class Color{
    GRAY,
    BLACK,
    WHITE,
}

fun Color.flipLeft(): Color = Color.WHITE

fun Color.flipRight(): Color = Color.BLACK