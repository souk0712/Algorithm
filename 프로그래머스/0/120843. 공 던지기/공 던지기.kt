class Solution {
    fun solution(numbers: IntArray, k: Int): Int {
        var index: Int = 0
        for(i in 0 until k - 1){
            index = (index + 2) % numbers.size
            print(index)
        }
        return numbers[index]
    }
}