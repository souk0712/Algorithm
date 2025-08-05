class Solution {
    fun solution(spell: Array<String>, dic: Array<String>): Int {
        var filterDic = dic.toList()
        spell.forEach { s ->
            filterDic = filterDic.filter { it.contains(s) }
        }
        if(filterDic.isEmpty()){
            return 2
        }else{
            return 1
        }
    }
}