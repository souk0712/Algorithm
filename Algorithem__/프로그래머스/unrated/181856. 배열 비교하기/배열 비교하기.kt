class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        val first = arr1.size.compareTo(arr2.size)
        return if (first == 0) {
            arr1.sum().compareTo(arr2.sum())
        } else {
            first
        }
    }
}