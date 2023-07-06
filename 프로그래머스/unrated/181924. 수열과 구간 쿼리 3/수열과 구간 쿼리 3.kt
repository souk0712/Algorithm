class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {  
        
        queries.forEach{ i ->
            val tmp = arr[i[0]]
            arr[i[0]] = arr[i[1]]
            arr[i[1]] = tmp
        }
        
        return arr
    }
}