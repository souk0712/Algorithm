import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        // A~Z(65~90) a~z(97~122)
        int[] answer = new int[52];
        char[] arr = my_string.toCharArray();
        
        for(int i =0;i<arr.length;i++){
            int word = (int) arr[i];
            
            if(word >= 65 && word <= 90){
                answer[arr[i] % 'A'] ++;
            }else{
                answer[arr[i] % 'a' + 26] ++;
            }
        }

        return answer;
    }
}