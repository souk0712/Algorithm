class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray {
        var answer = intArrayOf()
        flag.forEachIndexed { index, b ->
            if (b) {
                repeat(arr[index] * 2) {
                    answer += arr[index]
                }
            } else {
                answer = answer.dropLast(arr[index]).toIntArray()
            }
        }
        return answer
    }
}