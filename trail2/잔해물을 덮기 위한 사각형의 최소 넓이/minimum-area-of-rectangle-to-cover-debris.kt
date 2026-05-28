import java.util.Scanner

const val OFFSET = 1000
const val MAX_R = 2000

fun main() {
    val sc = Scanner(System.`in`)

    val x1 = sc.nextInt() + OFFSET
    val y1 = sc.nextInt() + OFFSET
    val x2 = sc.nextInt() + OFFSET
    val y2 = sc.nextInt() + OFFSET

    val bx1 = sc.nextInt() + OFFSET
    val by1 = sc.nextInt() + OFFSET
    val bx2 = sc.nextInt() + OFFSET
    val by2 = sc.nextInt() + OFFSET

    val g = Array(MAX_R + 1) { IntArray(MAX_R + 1) { 0 } }

    for (i in x1 until x2) {
        for (j in y1 until y2) {
            g[i][j] = 1
        }
    }

    for (i in bx1 until bx2) {
        for (j in by1 until by2) {
            g[i][j] = 2
        }
    }

    // 잔해물(1)의 최소/최대 경계를 찾기 위한 초기
    var minX = MAX_R
    var maxX = 0
    var minY = MAX_R
    var maxY = 0
    var firstExist = false

    for (i in 0..MAX_R) {
        for (j in 0..MAX_R) {
            if (g[i][j] == 1) {
                firstExist = true
                minX = minOf(minX, i)
                maxX = maxOf(maxX, i)
                minY = minOf(minY, j)
                maxY = maxOf(maxY, j)
            }
        }
    }

    // 출력
    if (!firstExist) {
        println(0)
    } else {
        val ans = (maxX - minX + 1) * (maxY - minY + 1)
        println(ans)
    }
}