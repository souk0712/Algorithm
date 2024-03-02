import kotlin.math.*

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer: Int = 0
        val list = listOf(a, b, c, d)
        val count = IntArray(7)
                
        list.forEach { count[it]++ }
        
        val max = count.maxOrNull() ?: 0

        when (max) {
            4 -> {
                answer += 1111 * list[0]
            }
            3 -> {
                val p = count.indexOf(3)
                val q = count.indexOf(1)
                answer += (10 * p + q) * (10 * p + q)
            }
            2 -> {
                var p = 0
                var q = 0

                for (i in 1..6) {
                    if (count[i] == 2) {
                        if (p == 0) p = i
                        else q = i
                    }
                }

                if (q != 0) answer = (p + q) * abs(p - q)
                else {
                    var r = 0
                    for (i in 1..6) {
                        if (count[i] == 1) {
                            if (q == 0) q = i
                            else r = i
                        }
                    }
                    answer += q * r
                }
            }
            1 -> {
                answer += list.minOrNull() ?: 0
            }
        }
        return answer
    }
}