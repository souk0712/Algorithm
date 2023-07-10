class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        var answer: String = ""
        for(i in 0 until my_strings.size){
            val str = my_strings[i]
            val (first, second) = parts[i]
            val sub = str.substring(first..second)
            answer += sub
        }
        return answer
    }
}