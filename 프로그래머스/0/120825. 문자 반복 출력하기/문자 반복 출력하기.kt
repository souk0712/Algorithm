class Solution {
    fun solution(my_string: String, n: Int): String {
        var answer = ""
        my_string.forEach{
            answer += it.toString().repeat(n)
        }
        return answer
    }
}