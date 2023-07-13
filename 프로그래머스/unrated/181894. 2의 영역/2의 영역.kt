class Solution {
    fun solution(arr: IntArray): IntArray {
        var first = -1
        var last = -1

        for (i in arr.indices) {
            if (arr[i] == 2) {
                if (first == -1)
                    first = i
                else
                    last = i
            }
        }

        return if (first == -1) {
            intArrayOf(-1)
        } else if (last == -1) {
            intArrayOf(arr[first])
        } else {
            arr.sliceArray(first..last)
        }
    }
}