class Solution {
    fun solution(my_string: String, indices: IntArray): String {
        val list = my_string.toMutableList()
        indices.sortDescending()

        for (index in indices){
            list.removeAt(index)
        }
        
        return list.joinToString("")
    }
}