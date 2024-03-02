import java.util.Scanner;

public class SWEA7465_창용마을무리의개수 {

	private static int N;
	private static int M;
	private static Edge[] edgelist;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			edgelist = new Edge[M];
			for (int i = 0; i < M; i++) {
				edgelist[i] = new Edge(sc.nextInt(), sc.nextInt());
			}

			makeSet();
			for (Edge e : edgelist) {
				unionSet(e.from, e.to);
			}
			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (parents[i] == i) {
					count++;
				}
			}
			System.out.println("#" + t + " " + count);
		}
	}

	private static int findSet(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = findSet(parents[a]);

	}

	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}

	static void makeSet() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static class Edge {
		int from, to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
}
