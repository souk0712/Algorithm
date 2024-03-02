import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val health = IntArray(n)
    val joy = IntArray(n)
    var st = StringTokenizer(readLine())
    for (i in 0 until n) {
        health[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(readLine())
    for (i in 0 until n) {
        joy[i] = st.nextToken().toInt()
    }

    val dp = Array(n + 1) { IntArray(100) { 0 } }
    for (i in 1..n) {
        for (j in 1..99) {
            if (health[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j].coerceAtLeast(joy[i - 1] + dp[i - 1][j - health[i - 1]])
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    print(dp[n][99])
}