import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1753_최단경로_Dijkstra {

	private static int V;
	private static int E;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();

		ArrayList<Data>[] list = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			list[i] = new ArrayList<>();
		}

		int start = sc.nextInt();
		int end = V;

		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			list[from].add(new Data(to, weight));
		}

		int[] D = new int[V + 1];
		boolean[] visited = new boolean[V + 1];

		Arrays.fill(D, Integer.MAX_VALUE);

		D[start] = 0;

		PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
		pq.offer(new Data(start, D[start]));
		int cnt = 0;
		while (!pq.isEmpty()) {
			Data minVertex = pq.poll();
			if (visited[minVertex.no]) {
				continue;
			}
			visited[minVertex.no] = true;
			cnt++;
			if (cnt == end) {
				break;
			}
			for (Data d : list[minVertex.no]) {
				if (visited[d.no]) {
					continue;
				}
				if (D[d.no] > D[minVertex.no] + d.weight) {
					D[d.no] = D[minVertex.no] + d.weight;
					pq.offer(new Data(d.no, D[minVertex.no] + d.weight));
				}
			}
		}
		for (int d = 1; d <= V; d++) {
			if (D[d] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(D[d]);
			}
		}
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
