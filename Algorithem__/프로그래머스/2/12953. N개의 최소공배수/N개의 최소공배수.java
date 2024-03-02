class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int compare = arr[0];
        for(int i = 1; i < arr.length; i++){
            compare = compare * arr[i] / gcd(compare, arr[i]);
        }
        return compare;
    }
    
    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}