class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer = 0
        var def = a
        included.forEach{
            if(it){
                answer += def
            }
            def += d
        }
        return answer
    }
}