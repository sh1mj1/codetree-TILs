import java.util.*
import kotlin.math.*

val sc = Scanner(System.`in`)
var bombCount = 0

val n = sc.nextInt()

data class Pos(
    val x: Int,
    val y: Int
)

val positions = mutableListOf<Pos>()

val initialGraph = Array(n) { x -> 
    IntArray(n) { y ->
         val now = sc.nextInt()
         if(now == 1) {
            positions.add(Pos(x, y))
            bombCount++
         }
         now
    }
}

var graph = initialGraph.deepCopy()
val maxPossibleExplosionCount = bombCount * 5

var ans = bombCount

data class DxDy(
    val dx: IntArray,
    val dy: IntArray
)

val dx1 = intArrayOf(1, 2, -1, -2)
val dy1 = intArrayOf(0, 0, 0, 0)

val dx2 = intArrayOf(0, 1, 0, -1)
val dy2 = intArrayOf(1, 0, -1, 0) 

val dx3 = intArrayOf(1, -1, 1, -1)
val dy3 = intArrayOf(1, 1, -1, -1)

val dxdy1 = DxDy(dx1, dy1)
val dxdy2 = DxDy(dx2, dy2)
val dxdy3 = DxDy(dx3, dy3)

val dxdyList = listOf(dxdy1, dxdy2, dxdy3)

var result = 0

fun main() {
    recursive(0, graph)
    println(result)
}

fun recursive(posIdx: Int, nowGraph: Array<IntArray>) {
    if (posIdx == positions.size) {
        result = max(result, ans)
        return
    }

    val (x, y) = positions[posIdx]
    for (dxdy in dxdyList) {
        val tempGraph = nowGraph.deepCopy()
        val nowMoveCount = move(x, y, dxdy, tempGraph)
        ans += nowMoveCount
        recursive(posIdx + 1, tempGraph)
        ans -= nowMoveCount
    }
}

fun move(x: Int, y: Int, dxdy: DxDy, nowGraph: Array<IntArray>): Int {
    var nowMoveCount = 0
    for (direction in 0..3) {
        val nextX = x + dxdy.dx[direction]
        val nextY = y + dxdy.dy[direction]

        if (canMoveTo(nextX, nextY, nowGraph)) {
            nowMoveCount++
            nowGraph[nextX][nextY] = 1
        }
    }
    return nowMoveCount
}

fun canMoveTo(x: Int, y: Int, nowGraph: Array<IntArray>): Boolean {
    if (x < 0 || y < 0) return false
    if (x >= n || y >= n) return false
    if (nowGraph[x][y] == 1) return false

    return true
}

fun Array<IntArray>.deepCopy() = Array(size) { this[it].clone() }