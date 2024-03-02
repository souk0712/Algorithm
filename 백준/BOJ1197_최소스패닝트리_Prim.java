import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1197_최소스패닝트리_Prim {

	private static int V;
	private static int E;
	private static ArrayList<Data>[] list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		list = new ArrayList[V+1];

		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			list[from].add(new Data(to, weight));
			list[to].add(new Data(from, weight));
		}
		
		int[] minEdge = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		minEdge[1] = 0;
		int result =0;
		
		PriorityQueue<Data> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.weight, o2.weight));
		pq.offer(new Data(1,minEdge[1]));
		int cnt =0;
		while (!pq.isEmpty()) {
			Data minVertex = pq.poll();
			if(visited[minVertex.no])continue;
			visited[minVertex.no] = true;
			result += minVertex.weight;
			cnt++;
			if(cnt==V) {
				break;
			}
			
			for(Data d: list[minVertex.no]) {
				if(visited[d.no])continue;
				if(minEdge[d.no]>d.weight) {
					minEdge[d.no] = d.weight;
					pq.offer(new Data(d.no, d.weight));
				}
			}
		}
		System.out.println(result);
	}

	static class Data {
		int no, weight;

		public Data(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

	}
}
