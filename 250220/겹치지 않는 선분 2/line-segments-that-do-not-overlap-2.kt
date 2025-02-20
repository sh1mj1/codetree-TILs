import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val x1 = IntArray(n)
    val x2 = IntArray(n)

    for (i in 0 until n) {
        x1[i] = scanner.nextInt()
        x2[i] = scanner.nextInt()
    }

    var ans = 0

    // 다른 선분과 겹치지 않는 선분의 수를 구합니다.
    for (i in 0 until n) {
        // i번째 선분이 다른 선분과 겹치지 않는지 확인합니다.
        var overlap = false

        for (j in 0 until n) {
            // 자기 자신은 제외합니다.
            if (j == i) continue

            // x1이 큰 쪽 선분이 x2가 더 작다면 겹치게 됩니다.
            if ((x1[i] <= x1[j] && x2[i] >= x2[j]) || (x1[i] >= x1[j] && x2[i] <= x2[j])) {
                overlap = true
                break
            }
        }

        // 겹치지 않았다면 정답의 개수에 하나를 추가합니다.
        if (!overlap) ans++
    }

    println(ans)
}