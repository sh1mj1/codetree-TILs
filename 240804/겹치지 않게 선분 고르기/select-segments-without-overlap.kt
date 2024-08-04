import java.util.*


val sc = Scanner(System.`in`)

data class Line(
    val x: Int,
    val y: Int
): Comparable<Line> {
    override fun compareTo(other: Line): Int {
        val compareY = y - other.y
        if(compareY != 0) return compareY

        return x - other.x
    }
}

val lines = mutableListOf<Line>()
val visited = BooleanArray(1001) { false }

var ans = 0

fun main() {
    input()
    
    lines.sort()

    for(line in lines) {
        if(visited[line.x] || visited[line.y]) {
            continue
        }

        for(i in line.x .. line.y) {
            visited[i] = true
        }
        ans++
    }
    println(ans)

}


fun input() {
    val n = sc.nextInt()

    repeat(n) {
        val x = sc.nextInt()
        val y = sc.nextInt()

        lines.add(Line(x, y))
    }
}