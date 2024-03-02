import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1240_노드사이의거리 {

	private static int N;
	private static int M;
	private static ArrayList<Item>[] arr;
	private static int[][] find;
	private static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new ArrayList[N + 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			int weight = sc.nextInt();
			arr[to].add(new Item(from, weight));
			arr[from].add(new Item(to, weight));
		}
		find = new int[M][2];
		
		for (int i = 0; i < find.length; i++) {
			find[i][0] = sc.nextInt();
			find[i][1] = sc.nextInt();
		}

		for (int i = 0; i < M; i++) {
			int sum = 0;
			visit = new boolean[N + 1];
			dfs(find[i][0], find[i][1], sum);
		}

	}

	private static void dfs(int i, int find, int sum) {
		if (i == find) {
			System.out.println(sum);
			return;
		}
		visit[i] = true;
		for (int j = 0; j < arr[i].size(); j++) {
			Item a = arr[i].get(j);
			if (visit[a.node]) {
				continue;
			}
			dfs(a.node, find, sum + a.weight);
		}
	}
}

class Item {
	int node, weight;

	public Item(int node, int weight) {
		super();
		this.node = node;
		this.weight = weight;
	}

}
