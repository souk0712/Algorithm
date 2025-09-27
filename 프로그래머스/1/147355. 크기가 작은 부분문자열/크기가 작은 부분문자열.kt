class Solution {
    fun solution(t: String, p: String): Int {
        val list = mutableListOf<String>()
        for(i in 0 .. t.length - p.length){
            list.add(t.substring(i, i + p.length))
        }
        
        return list.filter { p.toLong() >= it.toLong() }.size
    }
}