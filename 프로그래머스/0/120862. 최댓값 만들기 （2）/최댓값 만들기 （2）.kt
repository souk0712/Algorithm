class Solution {
    fun solution(numbers: IntArray): Int {
        var answer = Int.MIN_VALUE
        for(i1 in numbers.indices){
            for(i2 in numbers.indices){
                if(i1 == i2) continue
                val res = numbers[i1] * numbers[i2]
                if(answer < res){
                    answer = res
                }
            }
        }
        return answer
    }
}