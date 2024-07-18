import java.util.*

// 1sec 80MB

val sc = Scanner(System.`in`)

val n = sc.nextInt()
val k = sc.nextInt()

val arr = Array(n){
    IntArray(n) { sc.nextInt() }
}

val visited = Array(n) {
    BooleanArray(n) { false }
}

data class Node(
    val row: Int,
    val col: Int
)

val startPoints: List<Node> = List(k) {
    Node(
        sc.nextInt() - 1,
        sc.nextInt() - 1
    )
}

val qu: Queue<Node> = LinkedList<Node>()

val dr = intArrayOf(1, 0, -1, 0)
val dc = intArrayOf(0, 1, 0, -1)

fun canGo(r: Int, c: Int): Boolean {
    if(r < 0 || c < 0) return false

    if(r >= n || c >= n) return false

    if(visited[r][c]) return false

    if(arr[r][c] == 1) return false

    return true 
}

var ans = 0

fun main() {
    
    for(startPoint in startPoints){
        if(canGo(startPoint.row, startPoint.col)) {
            ans++
            qu.add(startPoint)
            visited[startPoint.row][startPoint.col] = true
        }
        
        while(!qu.isEmpty()) {
            val nowNode = qu.poll()

            val nowR = nowNode.row
            val nowC = nowNode.col

            for(dir in 0 .. 3) {
                val nextR = nowR + dr[dir]
                val nextC = nowC + dc[dir]
                if(canGo(nextR, nextC)) {
                    qu.add(Node(nextR, nextC))
                    visited[nextR][nextC] = true
                    ans++
                }
            }    
        }
    }
    println(ans)

}