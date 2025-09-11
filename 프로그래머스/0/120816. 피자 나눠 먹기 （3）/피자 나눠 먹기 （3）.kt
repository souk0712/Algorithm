class Solution {
    fun solution(slice: Int, n: Int): Int {
        return Math.ceil(n.toDouble() / slice).toInt()
    }
}