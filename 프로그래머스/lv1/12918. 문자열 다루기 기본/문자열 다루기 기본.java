class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length()==4||s.length()==6){
            answer = true;
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i++){
                if(chars[i] < '0' || chars[i] > '9'){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}