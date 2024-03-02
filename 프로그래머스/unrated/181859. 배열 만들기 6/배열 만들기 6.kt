class Solution {
    fun solution(arr: IntArray): IntArray {
        val answer = ArrayDeque<Int>()
        var i = 0
        while (i < arr.size) {
            i += if (answer.isEmpty()) {
                answer.add(arr[i])
                1
            } else {
                val last = answer.last()
                if (last == arr[i]) {
                    answer.removeLast()
                } else {
                    answer.add(arr[i])
                }
                1
            }
        }
        return answer.ifEmpty { listOf(-1) }.toIntArray()
    }
}