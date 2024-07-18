import java.util.*

// 1sec, 80MB

val sc = Scanner(System.`in`)
val colCount = sc.nextInt()
val rowCount = sc.nextInt()

val arr = Array(colCount) {
    IntArray(rowCount) { sc.nextInt() }
}

val visited = Array(colCount) {
    BooleanArray(rowCount) { false }
}

data class Pos(
    val row: Int,
    val col: Int
)

val qu: Queue<Pos> = LinkedList<Pos>()

var ans = 0

val dr = intArrayOf(1, 0, -1, 0)
val dc = intArrayOf(0, 1, 0, -1)

fun canGo(r: Int, c: Int): Boolean {
    if(r < 0 || c < 0) return false

    if(r >= rowCount || c >= colCount) return false

    if(visited[r][c]) return false

    if(arr[r][c] == 0) return false

    return true
}

fun bfs(){
     while(!qu.isEmpty()) {
        val nowNode = qu.poll()

        val nowR = nowNode.row
        val nowC = nowNode.col

        if(nowR == rowCount - 1 && nowC == colCount - 1) {
            ans = 1
            return
        }

        for(dir in 0 .. 3) {
            val nextR = nowR + dr[dir]
            val nextC = nowC + dc[dir]

            if(canGo(nextR, nextC)) {
                qu.add(Pos(nextR, nextC))
                visited[nextR][nextC] = true
            }
        }
    }
}

fun main() {
    // queue
    qu.add((Pos(0, 0)))
    visited[0][0] = true

    bfs()

    println(ans)
}