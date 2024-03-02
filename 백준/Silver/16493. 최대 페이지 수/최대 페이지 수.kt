fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val list = Array(m) { IntArray(2) }
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 0 until m) {
        val (day, page) = readln().split(" ").map { it.toInt() }
        list[i][0] = day
        list[i][1] = page
    }

    for (i in 1 until m + 1) {
        val cur = list[i - 1]
        for (j in 1 until n + 1) {
            if (cur[0] <= j) {
                dp[i][j] = Math.max(cur[1] + dp[i - 1][j - cur[0]], dp[i - 1][j])
            } else {
                dp[i][j] = dp[i - 1][j]
            }
        }
    }
    println(dp[m][n])
}