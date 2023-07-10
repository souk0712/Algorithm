class Solution {
    fun solution(my_string: String, m: Int, c: Int): String {
        var answer: String = ""
        for(i in my_string.indices step m){
            val str = my_string.substring(i, i + m)
            answer += str[c-1]
        }
        return answer
    }
}