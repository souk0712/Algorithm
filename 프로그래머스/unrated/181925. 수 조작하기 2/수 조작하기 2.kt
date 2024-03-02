class Solution {
    fun solution(numLog: IntArray): String {
        val map = mapOf(1 to 'w', -1 to 's', 10 to 'd', -10 to 'a')
        var answer = ""
        for (i in 0 until numLog.size - 1) {
            val a = numLog[i]
            val b = numLog[i + 1]
            val distance = b - a
            answer += map[distance]
        }

        return answer
    }
}