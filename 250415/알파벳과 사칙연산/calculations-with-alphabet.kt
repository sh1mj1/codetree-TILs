import kotlin.math.max

fun main() {
    val expression = readLine()!!
    // Please write your code here.

    val letterRange = 'a' .. 'f' 
    val numberRange = 1 .. 4

    val letters = expression.filter { it in letterRange}
    val distinctLetters = letters.toSet()
    val letterCount = distinctLetters.size
    
    val operators = expression.filter { it !in letterRange }

    val lettersMap = mutableMapOf<Char, Int>()
    for (letter in distinctLetters) {
        lettersMap.put(letter, 0)
    }

    val lettersKey = lettersMap.keys.toList()

    var answer = Int.MIN_VALUE

    fun calculate(operand1: Int, operand2: Int, operator: Char): Int {
        return when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            else -> error("invalid operator")
        }
    }

    fun calculate(numbers: List<Int>): Int {
        var operIdx = 0

        if (numbers.size == 1) return numbers.first()

        var operand1 = numbers[operIdx]
        var operand2 = numbers[operIdx + 1]

        while (operIdx < operators.length) {
            operand2 = numbers[operIdx + 1]
            operand1 = calculate(operand1, operand2, operators[operIdx])
            operIdx++
        }

        return operand1
    }


    fun findMax(depth: Int, curLetters: Map<Char, Int>) {
        if (depth >= letterCount) {
            val numbers = mutableListOf<Int>()
            for(l in letters) {
                numbers.add(curLetters[l]!!)
            }
            answer = max(answer, calculate(numbers))
            return
        }

        for (number in numberRange) {
            findMax(depth + 1, curLetters + (lettersKey[depth] to number))
            // println(lettersKey[depth])
        }
    }

    findMax(0, emptyMap())
    println(answer)

}