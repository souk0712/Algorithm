class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var calculateHP = hp
        val ants = intArrayOf(5, 3, 1)
        for(i in ants){
            answer += calculateHP / i
            calculateHP %= i
        }
        return answer
    }
}