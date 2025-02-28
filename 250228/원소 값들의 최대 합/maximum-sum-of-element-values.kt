fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val numbers = readLine()!!.split(" ").map { it.toInt() }

    val maxNumber = numbers.maxOrNull() ?: m
    // 에라토스테네스의 체를 이용하여 1부터 M까지의 소수를 찾음
    val isPrime = BooleanArray(maxNum + 1) { true }
        isPrime[0] = false
        isPrime[1] = false
        for (i in 2..maxNum) {
            if (isPrime[i]) {
                for (j in i * 2..maxNum step i) {
                    isPrime[j] = false
                }
            }
        }
    // 수열에서 소수만 추출하여 합 계산
    val primeSum = numbers.filter { isPrime[it] }.sum()

    println(primeSum)
}