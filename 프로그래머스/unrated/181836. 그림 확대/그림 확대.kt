class Solution {
    fun solution(picture: Array<String>, k: Int): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        picture.forEach { line ->
            var str = ""
            line.forEach { c ->
                repeat(k) {
                    str += c
                }
            }
            repeat(k) {
                answer += str
            }
        }
        return answer
    }
}