

fun main() {
    val n = readln().toInt()

    val moves = List(n) {
        val (direction, count) = readln().trim().split(" ")
        Move(
            direction = direction,
            count = count.toInt()
        )
    }
    var x = 0
    var y = 0
    
    moves.forEach {
        when (it.direction) {
            "E" -> x += it.count
            "S" -> y -= it.count
            "W" -> x -= it.count
            "N" -> y += it.count
        }
    }

    println(
        "$x $y"
    )
}

data class Move(
    val direction: String,
    val count: Int
)
