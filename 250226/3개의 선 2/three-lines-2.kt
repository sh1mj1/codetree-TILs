fun main() {
    val n = readln().toInt()
    val coordinates = List(n) {
        readln().trim().split(" ").map { it.toInt() }
    }

    var answer = 0

    for (i in 0..10) {
        for (j in 0..10) {
            for (k in 0..10) {
                var s = true

                // x만 3개
                if (coordinates.all { (x, _) -> x == i || x == j || x == k }) {
                    answer = 1
                }

                // y가 2개, x가 1개
                s = true
                if (coordinates.all { (x, y) -> x == i || y == j || y == k }) {
                    answer = 1
                }

                // y가 1개, x가 2개
                s = true
                if (coordinates.all { (x, y) -> x == i || x == j || y == k }) {
                    answer = 1
                }

                // y만 3개
                s = true
                if (coordinates.all { (_, y) -> y == i || y == j || y == k }) {
                    answer = 1
                }
            }
        }
    }

    println(answer)
}