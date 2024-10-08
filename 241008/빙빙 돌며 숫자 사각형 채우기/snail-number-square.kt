// time limit 1000ms

val rc = readln().split(" ").map{it.toInt()}
val n = rc[0]
val m = rc[1]

val lastNum = n * m // 16

val result = Array(n) {
    IntArray(n) { 0 }
}

val directions = arrayOf (
    intArrayOf(0, 1), // R
    intArrayOf(1, 0), // D
    intArrayOf(0, -1), // L
    intArrayOf(-1, 0), // U
)

fun main() {
    var idx = 1
    var r = 0
    var c = 0
    result[r][c] = idx
    var nowDir = directions[0]

    while(idx <lastNum) {
        val nextR = r + nowDir[0]
        val nextC = c + nowDir[1]

        if(!inRagne(nextR, nextC)) {
            nowDir = nextDirection(nowDir)
            continue
        }

        if(alreadyVisited(nextR, nextC)) {
            nowDir = nextDirection(nowDir)
            continue
        }

        r = nextR
        c = nextC
        result[r][c] = ++idx
    }

    result.forEach{ row ->
        row.forEach { i ->
            print("$i ")
        }
        println()
    }
}

fun alreadyVisited(r: Int, c: Int) : Boolean {
    return (result[r][c] != 0 )
}

fun inRagne(r: Int, c: Int): Boolean {
    return (r >= 0) && (c >= 0) && (r < n) && (c < m)
}

fun nextDirection(dir: IntArray): IntArray {
    if(dir == directions[0]) return directions[1]
    if(dir == directions[1]) return directions[2]
    if(dir == directions[2]) return directions[3]
    if(dir == directions[3]) return directions[0]
    return error(" ")
}