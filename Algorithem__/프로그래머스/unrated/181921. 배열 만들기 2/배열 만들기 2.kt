class Solution {
    fun solution(l: Int, r: Int): List<Int> = (l..r).filter { it.toString().all { c -> c == '5' || c == '0' } }.takeIf(List<Int>::isNotEmpty) ?: listOf(-1)
}