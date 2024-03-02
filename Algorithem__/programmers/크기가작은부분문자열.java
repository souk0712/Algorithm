import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n = p.length();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i <= t.length() - n; i++) {
            list.add(t.substring(i, i + n));
        }

        for (int i = 0; i < list.size(); i++) {
            if (Long.parseLong(p) >= Long.parseLong(list.get(i))) {
                answer++;
            }
        }

        return answer;
    }
}