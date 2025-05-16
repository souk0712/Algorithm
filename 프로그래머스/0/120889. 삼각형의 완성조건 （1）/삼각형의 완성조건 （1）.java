class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        int max = 0;
        int index = -1;
        for(int i = 0; i < sides.length; i++){
            if(max < sides[i]){
                max = sides[i];
                index = i;
            }
        }
        int sum = 0;
        for(int i = 0; i < sides.length; i++){
            if(i != index) {
                sum += sides[i];
            }
        }
        return max < sum? 1 : 2;
    }
}