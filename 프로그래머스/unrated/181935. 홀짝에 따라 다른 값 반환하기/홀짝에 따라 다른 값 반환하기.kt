class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        // 짝수
        if(n % 2 == 0){
            for(i in 0 .. n){
                if(i % 2 == 0){
                    answer += i*i
                }
            }
        } 
        // 홀수
        else { 
            for(i in 0 .. n){
                if(i % 2 != 0){
                    answer += i
                }
            }
        }
        
        return answer
    }
}