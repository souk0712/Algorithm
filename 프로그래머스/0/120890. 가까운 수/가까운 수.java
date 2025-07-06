class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int value = 1000;
        int diff = 1000;
        for(int i = 0; i < array.length; i++){
            int d = Math.abs(array[i] - n);
            if(d <= diff){
                if(diff == d){
                    value = Math.min(array[i], value);
                }else{
                    value = array[i];
                }
                diff = d;
            }
        }
        return value;
    }
}