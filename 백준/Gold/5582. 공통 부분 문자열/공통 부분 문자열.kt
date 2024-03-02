fun main() {
    val a = readln()
    val b = readln()
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            }
        }
    }

    var max = 0
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            max = dp[i][j].coerceAtLeast(max)
        }
    }
    print(max)
}