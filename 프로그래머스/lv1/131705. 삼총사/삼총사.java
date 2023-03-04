class Solution {
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        comb(number,0,0,0);
        return answer;
    }
    
    public static void comb(int[] number,int start,int sum, int cnt){
        if(cnt == 3){
            if(sum == 0){
                answer++;
                return;
            }
            return;
        }
        
        for(int i = start; i<number.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            comb(number,i+1,sum + number[i], cnt+1);
            visited[i] = false;
        }
    }
}