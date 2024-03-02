class Solution {
    fun solution(board: Array<IntArray>, k: Int): Int {
        var answer: Int = 0
        board.forEachIndexed { r, ints ->
            ints.forEachIndexed { c, i ->
                if (r + c <= k) {
                    answer += board[r][c]
                }
            }
        }
        return answer
    }
}