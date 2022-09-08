import java.util.Arrays;
import java.util.Scanner;

public class BOJ1197_최소스패닝트리_Krustal {
	private static Edge[] edgelist;
	private static int E;
	private static int V;
	private static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		edgelist = new Edge[E];
		for (int i = 0; i < E; i++) {
			edgelist[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(edgelist);
		
		makeSet();
		long res = 0;
		int count = 0;
		for (Edge e : edgelist) {
			if (unionSet(e.from, e.to)) {
				res += e.weight;
				count++;
			}
			if (count == V - 1) {
				break;
			}
		}
		System.out.println(res);

	}

	private static boolean unionSet(int i, int j) {
		int iRoot = findSet(i);
		int jRoot = findSet(j);
		if (iRoot == jRoot) {
			return false;
		}
		p[jRoot] = iRoot;
		return true;
	}

	private static int findSet(int i) {
		if (i == p[i])
			return i;
		return p[i] = findSet(p[i]);
	}

	private static void makeSet() {
		p = new int[V + 1];
		for (int i = 0; i <= V; i++) {
			p[i] = i;
		}
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
