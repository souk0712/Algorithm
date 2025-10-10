import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Node>[] list;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
        }

        dikjstra(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++){
            sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dikjstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue();
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(int k = 0; k < list[cur.n].size(); k++){
                Node next = list[cur.n].get(k);
                if(dist[next.n] > dist[cur.n] + next.cost){
                    dist[next.n] = dist[cur.n] + next.cost;
                    pq.offer(new Node(next.n, dist[next.n]));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int n, cost;

        Node(int n, int cost){
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(cost, o.cost);
        }
    }
}