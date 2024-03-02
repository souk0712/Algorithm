import kotlin.math.pow

class Solution {
    fun solution(num_list: IntArray): Int {
        val m = num_list.fold(1) { acc, i -> acc * i }
        val s = num_list.sum().toDouble().pow(2)
        return if (m < s) 1 else 0
    }
}