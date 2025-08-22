class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        val res = Math.sqrt(n.toDouble()).toInt()
        if(res * res == n){
            answer = 1
        }else{
            answer = 2
        }
        return answer
    }
}