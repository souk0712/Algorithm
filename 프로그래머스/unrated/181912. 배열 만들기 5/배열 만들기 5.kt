class Solution {
    fun solution(intStrs: Array<String>, k: Int, s: Int, l: Int): IntArray {
        var answer = intArrayOf()
        intStrs.forEach {
            val slice = it.substring(s, s + l).toInt()
            if (slice > k)
                answer += slice
        }
        return answer
    }
}