class Solution {
    fun solution(cipher: String, code: Int): String {
        var answer: String = ""
        val start = code - 1
        for(i in start until cipher.length step code){
            answer += cipher[i]
        }
        return answer
    }
}