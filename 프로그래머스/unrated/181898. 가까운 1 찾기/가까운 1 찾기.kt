class Solution {
    fun solution(arr: IntArray, idx: Int): Int = arr.indices.filter { it >= idx && arr[it] == 1 }.getOrNull(0) ?: -1
}