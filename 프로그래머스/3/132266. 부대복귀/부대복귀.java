import java.io.*;
import java.util.*;

class Solution {
    
    static ArrayList<Integer>[]list;
    static int[] answer;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        answer = new int[sources.length];
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < roads.length; i++){
            int to = roads[i][0];
            int from = roads[i][1];
            list[to].add(from);
            list[from].add(to);
        }
        
        for(int i = 0; i < sources.length; i++){
            if(sources[i] == destination) continue;
            answer[i] = dijkstra(sources[i], n, destination);
        }
        
        return answer;
    }
    
    static int dijkstra(int start, int n, int end){
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;
        q.offer(new Node(start, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            
            for(int k = 0; k < list[cur.next].size(); k++){
                int next = list[cur.next].get(k);
                if(visit[next]) continue;
                if(next == end){
                    return cur.cnt + 1;
                }
                q.offer(new Node(next, cur.cnt + 1));
                visit[next] = true;
            }
        }
        
        return -1;
    }
    
    static class Node {
        int next, cnt;
        
        Node(int next, int cnt){
            this.next = next;
            this.cnt = cnt;
        }
    }
}