class Solution {
    fun solution(arr: IntArray): Int {
        var answer: Int = 0
        var before = intArrayOf()
        while (!before.contentEquals(arr)) {
            before = arr.copyOf()
            for (i in arr.indices) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2
                } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                    arr[i] = arr[i] * 2 + 1
                }
            }
            answer++
        }
        return answer - 1
    }
}