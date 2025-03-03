fun main() {
    val n = readln().toInt()
    val ranges = List(n) { readln().split(" ").map { it.toInt() } }

    var x = 1

    while (true) {
        var currentX = x
        var valid = true

        for ((a, b) in ranges) {
            while (currentX < a) {
                currentX *= 2
            }
            if (currentX > b) {
                valid = false
                break
            }
        }

        if (valid) {
            println(x)
            return
        }

        x++
    }
}