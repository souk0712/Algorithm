class Solution {
    fun solution(arr: IntArray): IntArray {
        return if (arr.contains(2)) arr.copyOfRange(arr.indexOf(2), arr.lastIndexOf(2) + 1) else intArrayOf(-1)
    }
}