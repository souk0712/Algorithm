class Solution {
    fun solution(num_list: IntArray): Int {
        return (0 until num_list.size).filter{ num_list[it] < 0 }.getOrNull(0) ?: -1
    }
}