class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer = 0
        for (i in 0..myString.length - pat.length) {
            val chip = myString.substring(i, i + pat.length)
            if (chip == pat) {
                answer++
            }
        }
        return answer
    }
}