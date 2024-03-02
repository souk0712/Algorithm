class Solution {
    fun solution(n: Int, k: Int): IntArray {
        return (1..n).filter{i -> i % k == 0}.sorted().toIntArray()
    }
}