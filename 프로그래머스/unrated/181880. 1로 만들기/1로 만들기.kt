class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        for (i in num_list.indices) {
            while (num_list[i] != 1) {
                if (num_list[i] % 2 == 0) {
                    num_list[i] /= 2
                } else {
                    num_list[i] = (num_list[i] - 1) / 2
                }
                answer++
            }
        }
        return answer
    }
}