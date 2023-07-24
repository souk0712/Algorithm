class Solution {
    fun solution(arr: Array<IntArray>): Int {
        for(i in arr.indices){
            for(j in arr[i].indices){
                if(arr[i][j] != arr[j][i]){
                    return 0
                }
            }
        }
        return 1
    }
}