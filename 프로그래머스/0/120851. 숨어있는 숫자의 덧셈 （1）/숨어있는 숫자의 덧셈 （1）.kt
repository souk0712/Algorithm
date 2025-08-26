class Solution {
    fun solution(my_string: String): Int {
        var answer: Int = 0
        my_string.forEach { s ->
            if(s.isDigit()){
                answer += s - '0'
            }
        }
        return answer
    }
}