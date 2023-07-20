class Solution {
    fun solution(myStr: String): Array<String> {
        return myStr.split("a","b","c").filter(String::isNotEmpty).let{
            if(it.isEmpty()){
                arrayOf("EMPTY")
            }else{
                it.toTypedArray()
            }
        }
    }
}