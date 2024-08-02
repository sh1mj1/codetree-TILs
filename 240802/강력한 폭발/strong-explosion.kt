import java.util.Scanner

data class Pair(val x: Int, val y: Int)

const val BOMB_TYPE_NUM = 3
const val MAX_N = 20

var n = 0
val bombType = Array(MAX_N) { IntArray(MAX_N) }
val bombed = Array(MAX_N) { BooleanArray(MAX_N) }

var ans = 0
val bombPos = mutableListOf<Pair>()

fun inRange(x: Int, y: Int) = x in 0 until n && y in 0 until n

fun bomb(x: Int, y: Int, bType: Int) {
    val bombShapes = arrayOf(
        emptyArray(),
        arrayOf(Pair(-2, 0), Pair(-1, 0), Pair(0, 0), Pair(1, 0), Pair(2, 0)),
        arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, 0), Pair(0, -1), Pair(0, 1)),
        arrayOf(Pair(-1, -1), Pair(-1, 1), Pair(0, 0), Pair(1, -1), Pair(1, 1))
    )

    bombShapes[bType].forEach { (dx, dy) ->
        val nx = x + dx
        val ny = y + dy
        if (inRange(nx, ny)) {
            bombed[nx][ny] = true
        }
    }
}

fun calc(): Int {
    bombed.forEach { row -> row.fill(false) }

    bombPos.forEach { (x, y) ->
        if (bombType[x][y] > 0) {
            bomb(x, y, bombType[x][y])
        }
    }

    return bombed.sumOf { row -> row.count { it } }
}

fun findMaxArea(cnt: Int) {
    if (cnt == bombPos.size) {
        ans = maxOf(ans, calc())
        return
    }
    val (x, y) = bombPos[cnt]
    (1..3).forEach { i ->
        bombType[x][y] = i
        findMaxArea(cnt + 1)
        bombType[x][y] = 0
    }
}

fun <T> Array<T>.sumOf(selector: (T) -> Int): Int {
    var sum = 0
    for (element in this) {
        sum += selector(element)
    }
    return sum
}

fun main() {
    val sc = Scanner(System.`in`)
    n = sc.nextInt()

    for (i in 0 until n) {
        for (j in 0 until n) {
            val bombPlace = sc.nextInt()
            if (bombPlace > 0) {
                bombPos.add(Pair(i, j))
            }
        }
    }

    findMaxArea(0)
    println(ans)
}