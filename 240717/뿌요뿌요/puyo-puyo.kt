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

val ansList = IntArray(MAX_NUM + 1) { 0 }

val dr = intArrayOf(1, 0, -1, 0)
val dc = intArrayOf(0, 1, 0, -1)

fun canGo(r: Int, c: Int): Boolean {
    if(r < 0 || r >= N || c < 0 || c >= N) {
        return false
    }
    if(visited[r][c]){
        return false
    }
    return true
}

fun dfs(r: Int, c: Int) {
    if(!canGo(r, c)) {
        return
    }

    visited[r][c] = true
    val now = arr[r][c]
    ansList[now] += 1

    for(dir in 0 .. 3) {
        val nextR = r + dr[r]
        val nextC = c + dc[c]
        dfs(nextR, nextC)
    }

}


fun main() {
    for(r in 0 until N) {
        for (c in 0 until N){
            dfs(r, c)
        }
    }
    
    var max = 0
    var count = 0

    for(i in 1 .. 100) {
        if(ansList[i] >= 4) {
            count++
        }

        if(max < ansList[i]) {
            max = ansList[i]
        }
    }

    println("${count} ${max}")

}