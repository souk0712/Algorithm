class Solution {
    fun solution(strArr: Array<String>): Array<String> {
        return strArr.apply{
            for(i in this.indices){
                if(i % 2 == 0){
                    this[i] = this[i].lowercase()
                } else {
                    this[i] = this[i].uppercase()
                }
            }
        }
    }
}