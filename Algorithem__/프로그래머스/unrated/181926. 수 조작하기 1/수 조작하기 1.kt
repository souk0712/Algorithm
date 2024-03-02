class Solution {
    fun solution(n: Int, control: String): Int {
        var answer = n
        control.forEach { c ->
            when (c) {
                'w' -> answer++
                's' -> answer--
                'd' -> answer += 10                
                'a' -> answer -= 10
            }
        }
        return answer
    }
}