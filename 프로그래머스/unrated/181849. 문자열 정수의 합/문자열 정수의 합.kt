class Solution {
    fun solution(num_str: String): Int {
        return num_str.sumOf { it.digitToInt() }
    }
}