class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray {
        val dq = ArrayDeque<Int>()
        numbers.forEach{
            dq.add(it)
        }
        var d = 0
        if(direction == "left"){
            d = dq.removeFirst()
            dq.addLast(d)
        }else{
            d = dq.removeLast()
            dq.addFirst(d)
        }
        
        return dq.toIntArray()
    }
}