var ans = 0
val n = readln().toInt()

val sections = List(200_002) { Section(0, 0, 0) }
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
                    if(nowSection.recent == 3) {
                        break
                    }
                    nowSection.white++

                    if(nowSection.black >=2 && nowSection.white >= 2) {
                        nowSection.recent = 3
                    }else {
                        nowSection.recent = 2
                    }
                    if(i == count-1) {
                        break
                    }
                    nowPoint--
                }
            }
            "R" -> {
                for(i in 0 until count) {
                    val nowSection = sections[nowPoint]
                    if(nowSection.recent == 3 ) {
                        break
                    }
                    
                    nowSection.black++
                    if(nowSection.black >=2 && nowSection.white >= 2) {
                        nowSection.recent = 3
                    }else {
                        nowSection.recent = 1
                    }
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
    var gray = 0
    for(section in sections) {
        when(section.recent) {
            1 -> {black++}
            2 -> {white++}
            3 -> {gray++}
            else -> {}
        }
    }
    println("$white $black $gray")
}

data class Section(
    var black: Int,
    var white: Int,
    // 0: none, 1: black, 2: white, 3: gray
    var recent: Int
)