class Solution {
    fun solution(myString: String): String {
        var answer = ""
        for (i in myString.indices) {
            val c = myString[i]
            answer += if (c == 'a' || c == 'A') {
                c.uppercase()
            } else {
                c.lowercase()
            }
        }
        return answer
    }
}