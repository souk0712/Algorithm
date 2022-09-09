import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260_DFS와BFS {
	static boolean[] visited;
	static ArrayList<Integer> ans;
	static List<Integer>[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		arr = new List[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			List<Integer> tmp = arr[a];
			tmp.add(b);
			List<Integer> tmp2 = arr[b];
			tmp2.add(a);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(arr[i]);
		}

		visited = new boolean[N];
		ans = new ArrayList<>();
		dfs(V - 1);
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
		visited = new boolean[N];
		ans = new ArrayList<>();
		bfs(V - 1);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}

	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int current = q.poll();
			ans.add(current + 1);

			for (int i = 0; i < arr[current].size(); i++) {
				int temp = arr[current].get(i);

				if (!visited[temp]) {
					q.offer(temp);
					visited[temp] = true;
				}
			}
		}
	}

	static void dfs(int v) {
		if (visited[v])
			return;
		visited[v] = true;
		ans.add(v + 1);
		for (int j = 0; j < arr[v].size(); j++) {
			int temp = arr[v].get(j);
			dfs(temp);
		}
	}
}
