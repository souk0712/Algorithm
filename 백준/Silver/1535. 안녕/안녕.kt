import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    data class Hello(val l: Int, val j: Int)

    val n = readLine().toInt()
    val l = readLine().split(" ").map { it.toInt() }.toIntArray()
    val j = readLine().split(" ").map { it.toInt() }.toIntArray()

    val dp = Array(n + 1) { IntArray(100) { 0 } }
    val hello = mutableListOf<Hello>()
    for (i in 0 until n) {
        hello.add(Hello(l[i], j[i]))
    }
    hello.sortedWith(Comparator { o1, o2 -> o1.l.compareTo(o2.j) })
    for (i in 1..n) {
        val cur = hello[i - 1]
        for (j in 1..99) {
            if (cur.l <= j) {
                dp[i][j] = dp[i - 1][j].coerceAtLeast(cur.j + dp[i - 1][j - cur.l])
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    print(dp[n][99])
}