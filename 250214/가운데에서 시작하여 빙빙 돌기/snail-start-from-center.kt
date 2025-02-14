enum class Direction(val delta: Pair<Int, Int>) {
    RIGHT(0 to 1),
    UP(-1 to 0),
    LEFT(0 to -1),
    DOWN(1 to 0);

    fun next(): Direction {
        return values()[(ordinal + 1) % values().size]
    }
}

data class Point(var row: Int, var col: Int) {
    fun move(direction: Direction) {
        row += direction.delta.first
        col += direction.delta.second
    }
}

class Grid(val size: Int) {
    private val grid = MutableList(size) { MutableList(size) { 0 } }

    fun isInBounds(point: Point): Boolean {
        return point.row in 0 until size && point.col in 0 until size
    }

    fun setValue(point: Point, value: Int) {
        if (isInBounds(point)) {
            grid[point.row][point.col] = value
        }
    }

    fun printGrid() {
        grid.forEach { row -> println(row.joinToString(" ")) }
    }
}

class SpiralWriter(private val grid: Grid) {
    private var point = Point(grid.size / 2, grid.size / 2)
    private var num = 1
    private var direction = Direction.RIGHT
    private var dirCount = 0
    private var stepSize = 0

    fun writeAll() {
        val maxNum = grid.size * grid.size

        while (num <= maxNum) {
            if (dirCount % 2 == 0) stepSize++

            repeat(stepSize) {
                if (num > maxNum) return
                grid.setValue(point, num++)
                point.move(direction)
            }

            dirCount++
            direction = direction.next()
        }
    }
}

fun main() {
    val n = readln().toInt()

    val grid = Grid(n)
    val spiralWriter = SpiralWriter(grid)

    spiralWriter.writeAll()
    grid.printGrid()
}
