import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2252_줄세우기 {

	private static int N;
	private static int M;
	private static ArrayList<Integer>[] list;
	private static int[] inDegree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		inDegree = new int[N + 1];

		for (int m = 0; m < M; m++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[from].add(to);
			inDegree[to]++;
		}

		ArrayList<Integer> ans = topoloySort();
		for (int i : ans) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static ArrayList<Integer> topoloySort() {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}

		// BFS
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			ans.add(cur);
			for (int i : list[cur]) {
				if (--inDegree[i] == 0)
					queue.offer(i);
			}
		}
		return ans;
	}

}
