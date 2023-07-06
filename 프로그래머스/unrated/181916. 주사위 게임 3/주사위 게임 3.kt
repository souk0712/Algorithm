import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer: Int = 0
        val list = listOf(a, b, c, d)
        val set = list.distinct()
        val max = list.maxOrNull() ?: 0
        val count = IntArray(max + 1)

        list.forEach { count[it]++ }

        when (set.size) {
            4 -> {
                answer += list.minOrNull() ?: 0
            }
            3 -> {
                val p = set[0]
                val q = set[1]
                val r = set[2]

                if (count[p] == 2) {
                    answer += q * r
                } else if (count[q] == 2) {
                    answer += p * r
                } else if (count[r] == 2) {
                    answer += p * q
                }
            }
            2 -> {
                val p = set[0]
                val q = set[1]
                answer += if (count[p] == 3) {
                    (10 * p + q) * (10 * p + q)
                } else if (count[q] == 3) {
                    (10 * q + p) * (10 * q + p)
                } else {
                    (p + q) * abs(p - q)
                }
            }
            1 -> {
                answer += 1111 * list[0]
            }
        }
        return answer
    }
}