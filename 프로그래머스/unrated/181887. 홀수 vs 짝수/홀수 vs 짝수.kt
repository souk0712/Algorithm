import kotlin.math.*

class Solution {
    fun solution(num_list: IntArray): Int {
        val res =
            num_list.foldIndexed(0 to 0) { index, acc, i -> if (index % 2 == 0) acc.first + i to acc.second else acc.first to acc.second + i }
        return res.first.coerceAtLeast(res.second)
    }
}