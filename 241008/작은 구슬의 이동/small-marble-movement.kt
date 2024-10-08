val directions = arrayOf(
    intArrayOf(-1, 0), // U
    intArrayOf(1, 0), // D
    intArrayOf(0, 1), // R
    intArrayOf(0, -1), // L
)

val nt = readln().split(" ").map{it.toInt()}
val n = nt[0]
val t = nt[1]

val rcd = readln().split(" ")
var r = rcd[0].toInt()
var c = rcd[1].toInt()
var direction = direction(rcd[2].toString())

fun main() {
    var time = 0
    while(time < t) {
        var nextR = r + direction[0]
        var nextC = c + direction[1]

        if(!inRange(nextR,nextC)) {
            time++
            direction = reversedDirection(direction)
            continue
        }

        if(inRange(nextR,nextC)) {
            r = nextR
            c = nextC
        }
        time++
    }

    println("$r $c")
}


fun direction(cmd: String): IntArray {
    return when(cmd) {
        "U" -> directions[0]
        "D" -> directions[1]
        "R" -> directions[2]
        "L" -> directions[3]
        else -> throw error(" ")
    }
}

fun reversedDirection(direction: IntArray): IntArray {
    if(direction == directions[0]) return directions[1]
    if(direction == directions[1]) return directions[0]
    if(direction == directions[2]) return directions[3]
    if(direction == directions[3]) return directions[2]
    return error(" ")
}

fun inRange(r: Int, c: Int): Boolean = (r > 0) && (r <= n) && (c > 0) && (c <= n)