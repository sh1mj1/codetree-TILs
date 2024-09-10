val N = readln().toInt()

data class Rectangle(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int,
)

val axis = Array(202) {
    IntArray(202) { 0 }
}

 val rectangles = List(N) {
        val line = readln().split(" ").map { it.toInt() + 100 }
        Rectangle(
            x1 = line[0],
            y1 = line[1],
            x2 = line[2],
            y2 = line[3],
        )
    }


fun main() {
    var ans = 0

    for(rectangle in rectangles) {
        for(x in rectangle.x1 until rectangle.x2) {
            for(y in rectangle.y1 until rectangle.y2) {
                axis[x][y] = 1
            }
        }
    }

    for(x in 0 .. 201) {
        for(y in 0 .. 201) {
            if(axis[x][y] == 1) ans++
        }
    }
    println(ans)
}