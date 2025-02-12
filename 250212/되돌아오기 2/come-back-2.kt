

fun main() {
    val cmds = readln()

    val point = Point(0, 0)

    cmds.forEach {
        point.move(it)
        if (point.isOrigin()) {
            println(point.time)
            return
        }
    }
    println("-1")
}

data class Point(
    private var x: Int,
    private var y: Int,
) {
    private var dirIdx = 0
    var time = 0

    fun move(cmd: Char) {
        when (cmd) {
            'F' -> {
                x += directions[dirIdx].first
                y += directions[dirIdx].second
                time++
            }
            'R' -> {
                dirIdx++
                if (dirIdx > 3) dirIdx -= 4
                time++
            }
            'L' -> {
                dirIdx--
                if (dirIdx < 0) dirIdx += 4
                time++
            }
            else -> error("Invalid cmd")
        }
    }

    fun isOrigin(): Boolean = x == 0 && y == 0
    
    companion object {
        val directions = listOf(
            -1 to 0,
            0 to 1,
            1 to 0,
            0 to -1,
        )
    }
}

