class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.apply {
            for (i in this.indices) {
                if (this[i] >= 50 && this[i] % 2 == 0) {
                    arr[i]/=2
                } else if (this[i] < 50 && this[i] % 2 == 1) {
                    arr[i]*=2
                }
            }
        }
    }
}