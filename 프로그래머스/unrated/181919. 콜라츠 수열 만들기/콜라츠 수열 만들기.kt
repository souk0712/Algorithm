class Solution {
    fun solution(n: Int): IntArray {
        var answer = intArrayOf(n)
        var t = n
        while(t > 1){
            if(t % 2 == 0) t /= 2 
            else t = 3 * t + 1
            answer += t
        }
        return answer
    }
}