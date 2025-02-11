

fun main() {
    val cmds = readln().trim()

    val pos = Position(0, 0, 0)

    cmds.forEach {
        pos.move(it)
    }

    println(
        pos.now()
    )
}

data class Position(
    private var x: Int, 
    private var y: Int,
    private var dir: Int // 0: UP, 1: RIGHT, 2: DOWN, 3: LEFT
) {
    fun move(cmd: Char) {
        when (cmd) {
            'L' -> {
                dir -= 1
                if (dir <= -1) dir += 4
            }
            'R' -> {
                dir += 1
                if (dir >= 4) dir -= 4
            }
            'F' -> {
                when (dir) {
                    0 -> y += 1
                    1 -> x += 1
                    2 -> y -= 1
                    3 -> x -= 1
                    else -> error("invalid direction. dir: $dir")
                }
            }
            else -> error("invalid cmd. cmd: $cmd")
        }
    }

    fun now(): String = "$x $y"
}