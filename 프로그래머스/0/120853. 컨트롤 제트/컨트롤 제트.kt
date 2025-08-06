class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        val array = s.split(" ")
        var before = array[0].toInt()
        array.forEach { v ->
            if(v == "Z"){
                answer -= before
            }else {
                answer += v.toInt()
                before = v.toInt()
            }
        }
        return answer
    }
}