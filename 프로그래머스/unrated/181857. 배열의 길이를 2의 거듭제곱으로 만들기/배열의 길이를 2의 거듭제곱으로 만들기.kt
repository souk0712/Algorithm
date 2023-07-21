class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer: IntArray = arr.copyOf()
        val size = arr.size
        var temp = 1

        while (true) {
            if (size < temp) {
                for (i in 0 until temp - size)
                    answer += 0
                break
            }

            if (size == temp) {
                break
            }

            temp *= 2
        }

        return answer
    }
}