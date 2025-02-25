

fun main() {
    val elementsCount = readln().toInt()
    val elements = readln().trim().split(" ").map(String::toInt).sorted()

    val searchRange = elements[0] + 1 .. elements[elementsCount - 1] - 1

    val combinationsCount = searchRange.maxOf { target ->
        elements.count { small ->
            elements.any { large -> 
                small < target && (target - small == large - target)
            }
        }
    }

    println(combinationsCount)
}

