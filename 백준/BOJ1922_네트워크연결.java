import java.util.Arrays;
import java.util.Scanner;

public class BOJ1922_네트워크연결 {

	private static Edge[] edgelist;
	private static int[] p;
	private static int N;
	private static int M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		edgelist = new Edge[M];
		for (int i = 0; i < M; i++) {
			edgelist[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(edgelist);
		makeSet();

		int res = 0;
		int cnt = 0;
		for (Edge e : edgelist) {
			if (unionSet(e.from, e.to)) {
				res += e.weight;
			}
			if (cnt == N - 1) {
				break;
			}
		}
		System.out.println(res);

	}

	private static void makeSet() {
		p = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
	}

	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		p[bRoot] = aRoot;
		return true;
	}

	private static int findSet(int a) {
		if (a == p[a])
			return a;
		return p[a] = findSet(p[a]);
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}

}
