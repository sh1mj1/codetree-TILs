import kotlin.math.max

fun main() {
    val (bombsCount, validDistance) = readln().trim().split(" ").map(String::toInt)
    val bombs = List(bombsCount) { idx ->
        Bomb(idx, readln().toInt())
    }

    var maxExplodedBomb = -1

    for (bomb in bombs) {
        val foundBombs = bombs.filter { it.name == bomb.name }
            
        var shouldExplode = false
        for (i in 0 until foundBombs.size - 1) {
            if (foundBombs[i + 1].idx - foundBombs[i].idx <= validDistance) {
                shouldExplode = true
            }

            if (shouldExplode) {
                maxExplodedBomb = max(maxExplodedBomb, foundBombs[0].name)
                break
            }
        }
    }

    println(maxExplodedBomb)
}


data class Bomb(
    val idx: Int,
    val name: Int,
)