class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        arr.map { i -> repeat(i) { answer += i } }
        return answer
    }
}