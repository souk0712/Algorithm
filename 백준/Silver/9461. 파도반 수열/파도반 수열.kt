fun main() {
    val t = readln().toInt()
    val dp = LongArray(101)
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2
    for (i in 5 until 101) {
        dp[i] = dp[i - 5] + dp[i - 1]
    }

    for (i in 0 until t) {
        val n = readln().toInt()
        println(dp[n])
    }
}