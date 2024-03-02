class Solution {
    fun solution(n: Int): List<Int> {
        return generateSequence(n) { if (it == 1) null else if (it % 2 == 0) it / 2 else 3 * it + 1 }.toList()
    }
}