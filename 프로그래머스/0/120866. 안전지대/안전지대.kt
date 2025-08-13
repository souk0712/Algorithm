class Solution {
    
    val dx = intArrayOf(-1, 1, 0, 0, -1, -1, 1, 1)
    val dy = intArrayOf(0, 0, -1, 1, -1, 1, -1, 1)
    
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
        val n = board.size
        val map = Array(n, {IntArray(n)})
        
        for(i in board.indices){
            for(j in board.indices){
                if(board[i][j] == 1){
                    map[i][j] = 2
                    for(k in dx.indices){
                        val mx = dx[k] + i
                        val my = dy[k] + j
                        if(mx < 0 || mx >= n || my < 0 || my >= n) continue
                        map[mx][my] = 2
                    }
                }
            }
        }
        
        for(i in map.indices){
            for(j in map.indices){
                if(map[i][j] == 0) answer++
            }
        }
        
        return answer
    }
}