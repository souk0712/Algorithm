class Solution {
    fun solution(sides: IntArray): Int {
        var answer: Int = 0
        // case 1. 둘 중 한 변이 가장 긴 변인 경우
        val max = Math.max(sides[0], sides[1])
        val diff = Math.abs(sides[0] - sides[1])
        for(i in diff + 1 .. max){
            answer++
        }
        // case 2. 나머지 한 변이 가장 긴 변인 경우
        for(i in max + 1 until sides[0] + sides[1]){
            answer++
        }
        return answer
    }
}