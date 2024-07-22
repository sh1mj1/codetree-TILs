import java.util.*

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()

val arr = Array(n) {
    IntArray(n) {sc.nextInt()}
}

var visited = Array(n) {
    BooleanArray(n) {false}
}

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

var nowStartPos = Pos(sc.nextInt() -1 , sc.nextInt() -1)

data class Pos(
    val x: Int, 
    val y: Int
) {
    fun value() : Int {
        return arr[x][y]
    }

    fun isVisited(): Boolean {
        return visited[x][y]
    }

    fun isInRange(): Boolean {
        if(x < 0 || y < 0) return false 
        if(x >= n || y >= n) return false
        return true
    }

    fun visit() {
        visited[x][y] = true
    } 

    fun canGo(standardValue: Int): Boolean {
        if(!isInRange()) return false
        if(isVisited()) return false
        if(value() >= standardValue) return false
        return true
    }

    companion object {
        val NULL = Pos(-1, -1)
    }
}

val qu: Queue<Pos> = LinkedList<Pos>()

fun bfs() {
    qu.add(nowStartPos)
    visited[nowStartPos.x][nowStartPos.y] = true

    val standardValue = arr[nowStartPos.x][nowStartPos.y]

    while(!qu.isEmpty()) {
        val nowBfsPos = qu.poll()

        for(i in 0 .. 3) {
            val nextX = nowBfsPos.x + dx[i]
            val nextY = nowBfsPos.y + dy[i]

            val nextPos = Pos(nextX, nextY)

            if(nextPos.canGo(standardValue)) {
                qu.add(nextPos)
                nextPos.visit()
            }
        }
    }
}

fun isRequiredUpdate(bestPos: Pos, newPos: Pos): Boolean {
    if(bestPos == Pos.NULL) {
        return true
    }

    if(bestPos.value() != newPos.value()) {
        return newPos.value() > bestPos.value()
    }
    if(bestPos.x != newPos.x) {
        return bestPos.x > newPos.x
    } 
    if(bestPos.y != newPos.y) {
        return bestPos.y > newPos.y
    }
    return true
}

fun move(): Boolean {
    visited = Array(n) {
        BooleanArray(n) {false}
    }

    bfs()

    // find the best posiiton
    var bestPos = Pos.NULL

    for(i in 0 .. n-1) {
        for(j in 0 .. n-1) {
            if(!visited[i][j]) continue

            if(i == nowStartPos.x && j == nowStartPos.y) continue

            val newPos = Pos(i, j)

            if(isRequiredUpdate(bestPos, newPos)) {
                bestPos = newPos
            }
        }
    }

    if(bestPos == Pos.NULL){
        return false
    }else{
        nowStartPos = bestPos
        return true
    }
    
}

fun main() {
    for(i in 0 until k) {
        val isMoved = move()
        if(!isMoved) {
            break
        }
    }

    println("${nowStartPos.x + 1} ${nowStartPos.y + 1}")

}