import kotlin.math.max
import kotlin.math.min


data class Rectangle(
    val x1: Int,
    val y1: Int,
    val x2: Int,
    val y2: Int,
)

val axis = Array(2_002) {
    IntArray(2_002) { 0 }
}

 val rectangles = List(3) {
        val line = readln().split(" ").map { it.toInt() + 1_000 }
        Rectangle(
            x1 = line[0],
            y1 = line[1],
            x2 = line[2],
            y2 = line[3],
        )
    }

fun main() {
    color(rectangles[0], 1)
    color(rectangles[1], 1)
    color(rectangles[2], 0)

    
    val minx = min(rectangles[0].x1 , rectangles[1].x1)
    val maxX = max(rectangles[0].x2 , rectangles[1].x2)
    val minY = min(rectangles[0].y1 , rectangles[1].y1)
    val maxY = max(rectangles[0].y2 , rectangles[1].y2)

    var ans = 0

    for(x in minx until maxX) {
        for(y in minY until maxY) {
            if(axis[x][y] == 1) ans++
        }
    }

    println(ans)
}

fun color(rectangle: Rectangle, flag: Int) {
    for(x in rectangle.x1 until rectangle.x2) {
        for(y in rectangle.y1 until rectangle.y2) {
            axis[x][y] = flag
        }
    }
}