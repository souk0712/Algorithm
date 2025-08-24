class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        val a = array.sorted()
        answer = a[array.size / 2]
        return answer
    }
}