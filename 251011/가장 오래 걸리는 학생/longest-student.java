import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static ArrayList<Node>[] list;
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
        }
        
        dikjstra(n);
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++){
            ans = Math.max(ans, dist[i]);
        }
        System.out.println(ans);
    }

    static void dikjstra(int start){
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue();
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(Node next : list[cur.n]){
                int cost = dist[cur.n] + next.cost;if(dist[next.n] > cost){
                    dist[next.n] = cost;pq.offer(new Node(next.n, dist[next.n]));
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