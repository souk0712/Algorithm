
class Solution {
    
    static String[] word = {"aya", "ye", "woo", "ma"};
    static String[] pick;
    static boolean[] visited;
    static int answer;
    
    public int solution(String[] babbling) {
        answer = 0;
        for (int i = 0; i < babbling.length; i++) {

            for (int j = 1; j <= word.length; j++) {
                pick = new String[j];
                visited = new boolean[4];
                comb(babbling[i], 0, j);
            }
        }

        return answer;
    }
    
    private static void comb(String target, int cnt, int n) {
        if (cnt == n) {
            StringBuilder sb = new StringBuilder();
            String str = "";
            for (int i = 0; i < pick.length; i++) {
                str = sb.append(pick[i]).toString();
            }
            if (target.equals(str)) {
                answer++;
                return;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick[cnt] = word[i];
                comb(target, cnt + 1, n);
                visited[i] = false;
            }
        }
    }
}