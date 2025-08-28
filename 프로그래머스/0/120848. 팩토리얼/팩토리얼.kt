class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        val dp = IntArray(11)
        factorial(dp, 10)
        dp.forEachIndexed { index, num ->
            if(num <= n){
                answer = index
            }
        }
        return answer
    }
    
    fun factorial(dp : IntArray, n : Int) : Int{
        if(n == 1 || n == 0){
            return 1;
        }
        dp[n] = n * factorial(dp, n - 1)
        return dp[n]
    }
}