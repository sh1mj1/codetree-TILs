enum class Direction(val d: Pair<Int, Int>) {
    UP(-1 to 0),
    RIGHT(0 to 1),
    DOWN(1 to 0),
    LEFT(0 to -1);

    fun turnLeft(): Direction {
        val size = values().size
        return values()[(ordinal + size - 1) % size]
    }

    fun turnRight(): Direction {
        val size = values().size
        return values()[(ordinal + 1) % size]
    }
}

class Grid(private val grid: List<List<Int>>) {
    private val size = grid.size
    private val range = 0 until size

    fun isValid(row: Int, col: Int): Boolean = row in range && col in range

    fun value(row: Int, col: Int): Int = 
        if (isValid(row, col)) grid[row][col] 
        else 0
}

data class Point(
    var row: Int, 
    var col: Int, 
    var direction: Direction, 
    private val grid: Grid
) {
    var sum: Int = grid.value(row, col)

    fun execute(cmd: Char) {
        when (cmd) {
            'L' -> direction = direction.turnLeft()
            'R' -> direction = direction.turnRight()
            'F' -> move()
        }
    }

    fun move() {
        val (dr, dc) = direction.d
        val nextRow = row + dr
        val nextCol = col + dc

        if (grid.isValid(nextRow, nextCol)) {
            row = nextRow
            col = nextCol
            sum += grid.value(row, col)
        }
    }
}

fun main() {
    val (gridSize, cmdsCount) = readln().trim().split(" ").map(String::toInt)
    val cmds = readln().trim()
    val gridData = List(gridSize) { readln().trim().split(" ").map(String::toInt) }
    
    val grid = Grid(gridData)
    val point = Point(gridSize / 2, gridSize / 2, Direction.UP, grid)

    cmds.forEach { point.execute(it) }

    println(point.sum)
}
