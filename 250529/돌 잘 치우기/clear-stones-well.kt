import kotlin.math.max
import java.util.*

fun main() {
    val (n, k, m) = readln().trim().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().trim().split(" ").map { it.toInt() } }
    val stonePos = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                stonePos.add(i to j)
            }
        }
    }
    val sPos = mutableListOf<Pair<Int, Int>>()
    repeat(k) {
        val (r, c) = readln().trim().split(" ").map { it.toInt() }
        sPos.add((r - 1) to (c - 1))
    }
    // Please write your code here.
    
    fun removedCombis() : List<List<Pair<Int, Int>>> {
        val allCombis = mutableListOf<List<Pair<Int, Int>>>()
        
        fun remove(start: Int, combi: List<Pair<Int, Int>>) {
            if (combi.size == m) {
                allCombis.add(combi)
                return
            }
            
            for (i in start until stonePos.size) {
                remove(i + 1, combi + stonePos[i])
            }
        }
        remove(0, emptyList())
        
        return allCombis
    }
    
    val removedCombis = removedCombis()
    var ans = 0
    
    val dr = listOf(-1, 1, 0, 0)
    val dc = listOf(0, 0, -1, 1)
    
    fun valid(r: Int, c: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Boolean {
        return (r in 0 until n) && (c in 0 until n) && !visited[r][c] && grid[r][c] == 0
    }
    
    fun bfs(r: Int, c: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        val qu: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>().apply {
            add(r to c)
        }
        var count = 0
        
        while (qu.isNotEmpty()) {
            val polled = qu.poll()
            count++
            
            for (d in dr.indices) {
                val nextR = polled.first + dr[d]            
                val nextC = polled.second + dc[d]
                
                if (valid(nextR, nextC, grid, visited)) {
                    qu.add(nextR to nextC)
                    visited[nextR][nextC] = true
                }
            }
        }
        return count
    }
    
    removedCombis.forEach { combi ->
        val copiedGrid = Array(n) { r ->
            grid[r].toIntArray()
        }
        
        combi.forEach { p ->
            val (r, c) = p.first to p.second
            copiedGrid[r][c] = 0
        }

        val visited = Array(n) { BooleanArray(n) { false } }
        sPos.forEach { start ->
            val (r, c) = start.first to start.second
            bfs(r, c, copiedGrid, visited)
        }
        val reachCount = (0 until n).sumOf { row ->
            (0 until n).count { col ->
                visited[row][col] == true
            }
        }
        ans = max(ans, reachCount)
    }
    println(ans)
}