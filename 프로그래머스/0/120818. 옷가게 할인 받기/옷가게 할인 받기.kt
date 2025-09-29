class Solution {
    fun solution(price: Int): Int {
        return if(price >= 500_000){
            (price * 0.8).toInt()
        }else if(price >= 300_000){
            (price * 0.9).toInt()
        }else if(price >= 100_000){
            (price * 0.95).toInt()
        }else{
            price
        }
    }
}