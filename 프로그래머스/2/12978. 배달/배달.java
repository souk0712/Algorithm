import java.io.*;
import java.util.*;

class Solution {
    
    static int[] dist;
    static ArrayList<Node>[] list;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        list = new ArrayList[N + 1];
        for(int i = 1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0;i < road.length; i++){
            int[] r = road[i];
            list[r[0]].add(new Node(r[1], r[2]));
            list[r[1]].add(new Node(r[0], r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.n] < cur.cost){
                continue;
            }
            
            for(int k = 0; k < list[cur.n].size(); k++){
                Node next = list[cur.n].get(k);
                if(dist[next.n] > cur.cost + next.cost){
                    dist[next.n] = cur.cost + next.cost;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
        
        for(int i = 1; i < dist.length; i++){
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
    
    class Node implements Comparable<Node> {
        int n, cost;
        
        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(o.cost, cost);
        }
    }
}