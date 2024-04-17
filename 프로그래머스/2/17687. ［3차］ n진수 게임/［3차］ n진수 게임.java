class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sample = new StringBuilder();
        int turn = 0;
        sample.append(0);
        while(sample.length() < 100001){
            sample.append(Integer.toString(turn, n));
            turn++;
        }
        int pp = p;
        for(int i = 0; i < t; i++){
            char c = sample.charAt(pp);
            answer.append(c);
            pp += m;
        }
        return answer.toString().toUpperCase();
    }
}