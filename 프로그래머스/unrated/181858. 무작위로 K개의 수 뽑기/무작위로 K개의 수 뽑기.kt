class Solution {
    fun solution(arr: IntArray, k: Int): IntArray {
        val uniqueArr = arr.toSet().toList()
        var result = uniqueArr.take(k).toIntArray()
        if (result.size < k) {
            repeat(k - result.size) {
                result += -1
            }
        }
        return result
    }
}