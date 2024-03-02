import kotlin.math.max
class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val max = max(arr.size, arr[0].size)
        val answer = Array(max) { IntArray(max) { 0 } }
        arr.forEachIndexed { r, ints ->
            ints.forEachIndexed { c, i ->
                answer[r][c] = i
            }
        }
        return answer
    }
}