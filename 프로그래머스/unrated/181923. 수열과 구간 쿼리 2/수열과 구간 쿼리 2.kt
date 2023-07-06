import kotlin.math.*

class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()

        queries.forEach { (s, e, k) ->
            var min = Int.MAX_VALUE
            for (i in 0 .. arr.lastIndex) {
                if (i in s..e && arr[i] > k) {
                    min = min(arr[i], min)
                }
            }
            answer += if (min == Int.MAX_VALUE)
                -1
            else min
        }
        return answer
    }
}