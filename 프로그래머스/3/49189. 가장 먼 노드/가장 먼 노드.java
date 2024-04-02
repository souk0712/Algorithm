import java.io.*;
import java.util.*;

class Solution {

    static ArrayList<Integer>[] list;
    static final int INF = 50_001;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        for(int i = 1;i <= n; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, INF);
        
        for(int i = 0; i < edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            list[from].add(to);
            list[to].add(from);
        }
        
        dijkstra(1);
        
        int answer = 0;
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(dist[i], max);
        }
        
        for(int i = 1; i <= n; i++){
            if(max == dist[i]){
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dijkstra(int start){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{return Integer.compare(o1[1],o2[1]);});
        dist[start] = 0;
        pq.offer(new int[]{start, dist[start]});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            for(int i = 0; i < list[cur[0]].size(); i++){
                int next = list[cur[0]].get(i);
                if(dist[next] > cur[1] + 1){
                    dist[next] = cur[1] + 1;
                    pq.offer(new int[]{next, dist[next]});
                }
                
            }
        }
    }
}