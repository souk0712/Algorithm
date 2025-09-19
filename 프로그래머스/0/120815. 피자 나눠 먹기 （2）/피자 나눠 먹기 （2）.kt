class Solution {
    fun solution(n: Int): Int {
        return lcm(n, 6) / 6
    }
    
    fun gcd(n: Int, m: Int): Int{
        var num1 = n
        var num2 = m
        while(num2 != 0){
            val r = num1 % num2
            num1 = num2
            num2 = r
        }
        
        return num1
    }
    
    fun lcm(n:Int, m:Int): Int = n * m / gcd(n, m)
}