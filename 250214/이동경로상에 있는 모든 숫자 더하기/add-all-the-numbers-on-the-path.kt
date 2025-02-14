val nt = readln().trim().split(" ").map(String::toInt)
val gridSize = nt[0]
val cmdsCount = nt[1]

val gridRange = 0 until gridSize

val cmds = readln().trim()

val grid = List(gridSize) {
    readln().trim().split(" ").map(String::toInt)
}

enum class Direction(val d: Pair<Int, Int>) {
    UP(-1 to 0),
    RIGHT(0 to 1),
    DOWN(1 to 0),
    LEFT(0 to -1);

    fun turnLeft(): Direction {
        val size = values().size
        return values()[
            (ordinal + size - 1) % size
        ]
    }

    fun turnRight(): Direction {
        val size = values().size
        return values()[
            (ordinal + 1) % size
        ]
    }
}

data class Point(
    private var row: Int,
    private var col: Int,
    private var direction: Direction,
) {
    var sum: Int = grid[row][col]

    fun perform(cmd: Char, gridRange: IntRange) {
        when (cmd) {
            'L' -> {
                direction = direction.turnLeft()
            }
            'R' -> {
                direction = direction.turnRight()
            }
            'F' -> {
                move(gridRange)   
            }
        }
    }

    fun move(gridRange: IntRange) {
        val (dr, dc) = direction.d
        val nextRow = row + dr
        val nextCol = col + dc

        if (nextRow in gridRange && nextCol in gridRange) {
            row = nextRow
            col = nextCol
            sum += grid[row][col]
        }
    }
}

fun main() {
    val point = Point(
        row = gridSize / 2,
        col = gridSize / 2,
        direction = Direction.UP,
    )

    cmds.forEach { cmd ->
        point.perform(cmd, gridRange)
    }

    println(point.sum)
}