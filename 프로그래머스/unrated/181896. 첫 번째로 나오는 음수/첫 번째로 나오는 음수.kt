class Solution {
    fun solution(num_list: IntArray): Int {
        return num_list.indexOfFirst { it < 0 }
    }
}