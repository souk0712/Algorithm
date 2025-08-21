class Solution {
    fun solution(n: Int): Int {
        val isPrime = BooleanArray(n + 1){ true }
        isPrime[0] = false
        isPrime[1] = false
        for(i in 2 .. n){
            if(!isPrime[i]) continue
            for(j in i * 2 .. n step i){
                isPrime[j] = false
            }
        }
        return isPrime.filter{ !it }.size - 2
    }
}