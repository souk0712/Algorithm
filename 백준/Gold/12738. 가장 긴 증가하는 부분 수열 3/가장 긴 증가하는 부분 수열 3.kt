fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toLong() }
    val dp = LongArray(N) { -1_000_000_001 }
    fun binarySearch(target: Long, start: Int, end: Int, size: Int): Int {
        var idx = 0;
        var s = start
        var e = end
        while (s <= e) {
            val mid = (s + e) / 2
            if (target <= dp[mid]) {
                idx = mid
                e = mid - 1
            } else {
                s = mid + 1
            }
        }
        return idx.takeUnless { s == size } ?: -1
    }

    var LIS = 0
    for (i in list) {
        val idx = binarySearch(i, 0, LIS, LIS + 1)
        if (idx == -1) {
            dp[LIS++] = i;
        } else {
            dp[idx] = i;
        }
    }
    println(LIS)
}