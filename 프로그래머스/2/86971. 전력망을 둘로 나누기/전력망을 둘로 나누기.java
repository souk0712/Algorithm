import java.io.*;
import java.util.*;

class Solution {
    
    static int answer;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    
    public int solution(int n, int[][] wires) {
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < wires.length; i++){
            int[] wire = wires[i];
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }
        dfs(1);
        int left = 0;
        int right = 0;
        for(int i = 1;i<=n;i++){
            if(visit[i])left++;
            else right++;
        }
        answer = Math.abs(left - right);
        for(int i = 0; i < wires.length; i++){
            visit = new boolean[n + 1];
            init(wires, n, i);
        }
        
        return answer;
    }

    static void init(int[][] wires, int n, int w) {
        int[] wire = wires[w];
        list[wire[0]].remove(Integer.valueOf(wire[1]));
        list[wire[1]].remove(Integer.valueOf(wire[0]));
        dfs(1);
        int left = 0;
        int right = 0;
        for(int i = 1;i<=n;i++){
            if(visit[i])left++;
            else right++;
        }
        answer = Math.min(Math.abs(left - right),answer);
        list[wire[0]].add(wire[1]);
        list[wire[1]].add(wire[0]);
    }
        
    static void dfs(int cur) {
        if(visit[cur]) return;
        visit[cur] = true;
        
        for(int k = 0; k < list[cur].size(); k++){
            int next = list[cur].get(k);
            if(visit[next]) continue;
           dfs(next);
        }
    }
}