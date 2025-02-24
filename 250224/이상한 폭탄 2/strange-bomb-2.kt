import kotlin.math.max
import kotlin.math.abs

fun main() {
    val (bombsCount, validDistance) = readln().trim().split(" ").map(String::toInt)
    val bombs = List(bombsCount) { idx ->
        Bomb(idx, readln().toInt())
    }


    val maxExplodedBomb = bombs.filter { bomb ->
        bombs
            .filter { it.name == bomb.name }
            .windowed(2)
            .any { it[1].shouldExplode(it[0], validDistance) }
    }.maxOfOrNull { it.name } ?: -1

    println(maxExplodedBomb)

}


data class Bomb(
    val idx: Int,
    val name: Int,
) {
    fun shouldExplode(other: Bomb, validDistance: Int): Boolean =
         abs(other.idx - idx) <= validDistance
}