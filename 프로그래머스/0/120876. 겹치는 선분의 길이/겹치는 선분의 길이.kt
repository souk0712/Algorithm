class Solution {
    fun solution(lines: Array<IntArray>): Int {
        val count = IntArray(300)
        lines.forEach{
            for(i in it[0] until it[1]){
                count[i + 100]++
            }
        }
        return count.count{it >= 2}
    }
}