fun main() {
    // 3킬로그램 봉지와 5킬로그램 봉지
    // 최대한 적은 봉지
    val INF = 5_001
    val n = readln().toInt()
    val dp = IntArray(INF) { INF }
    dp[3] = 1
    dp[5] = 1
    for (i in 6 until INF) {
        val three = dp[i - 3]
        val five = dp[i - 5]

        if (three != INF) {
            dp[i] = dp[i].coerceAtMost(three + 1)
        }
        if (five != INF) {
            dp[i] = dp[i].coerceAtMost(five + 1)
        }
    }

    println(dp[n].takeIf { INF != it } ?: -1)
}