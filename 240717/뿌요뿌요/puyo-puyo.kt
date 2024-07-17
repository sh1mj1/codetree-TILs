import java.util.*
import kotlin.math.*
// 1sec 80MB

const val MAX_N = 100
const val MIN_N = 1

const val MIN_NUM = 1
const val MAX_NUM = 100

val sc = Scanner(System.`in`)

val N = sc.nextInt()
val arr = Array(N) {
    IntArray(N) { sc.nextInt() }
}

val visited = Array(N) {
    BooleanArray(N) { false }
}

val dr = intArrayOf(1, 0, -1, 0)
val dc = intArrayOf(0, 1, 0, -1)

var boomBlockCount = 0
var maxAdjBlockSize = 1

fun canGo(r: Int, c: Int): Boolean {
    if(r < 0 || r >= N || c < 0 || c >= N) {
        return false
    }
    if(visited[r][c]){
        return false
    }

    return true
}

var adjCount = 0

fun dfs(r: Int, c: Int) {
    adjCount++
    visited[r][c] = true
    

    for(dir in 0 .. 3) {
        val nextR = r + dr[dir]
        val nextC = c + dc[dir]

        if(!canGo(nextR, nextC)) {
            continue
        }

        if(arr[r][c] == arr[nextR][nextC]){
            dfs(nextR, nextC)
        }
    }

}


fun main() {
    for(r in 0 until N) {
        for (c in 0 until N){
            if(canGo(r,c)) {
                dfs(r, c)
            }
            
            if(adjCount >= 4) {
                boomBlockCount++
            }
            maxAdjBlockSize = max(maxAdjBlockSize, adjCount)

            adjCount = 0
        }
    }


    println("${boomBlockCount} ${maxAdjBlockSize}")

}