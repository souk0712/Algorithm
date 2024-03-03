fun main() {
    val n = readln().toInt()
    val time = IntArray(n)
    val payment = IntArray(n)
    val dp = IntArray(n + 1)
    for (i in 0 until n) {
        val (t, p) = readln().split(" ").map { it.toInt() }
        time[i] = t
        payment[i] = p
    }

    dp[0] = payment[0]

    for (i in n - 1 downTo 0) {
        val next = i + time[i]

        if (next > n) {
            dp[i] = dp[i + 1]
        } else {
            dp[i] = dp[i + 1].coerceAtLeast(payment[i] + dp[next])
        }
    }

    println(dp[0])
}