import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2623_음악프로그램 {

	static ArrayList<Integer>[] list;
	private static int N;
	private static int M;
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
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			int[] input = new int[num];
			for (int j = 0; j < num; j++) {
				input[j] = sc.nextInt();
			}
			for (int k = 0; k < input.length - 1; k++) {
				list[input[k]].add(input[k + 1]);
				inDegree[input[k + 1]]++;
			}
		}
		ArrayList<Integer> result = bfs();

		for (int i : result) {
			System.out.println(i);
		}
	}

	private static ArrayList<Integer> bfs() {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			ans.add(cur);
			for (int i : list[cur]) {
				if (--inDegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		if(ans.size()!=N) {
			ans = new ArrayList<>();
			ans.add(0);
			return ans;
		}
		return ans;
	}

}
