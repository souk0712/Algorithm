class Solution {
    fun solution(arr: IntArray): IntArray {
        val size = arr.size
        var n = 1
        while (n < size) {
            n *= 2
        }
        return arr + IntArray(n - size) { 0 }
    }
}