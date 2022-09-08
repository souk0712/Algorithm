import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1238_Contact {

	static ArrayList<Integer>[] list;
	private static int start;
	private static int N;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			start = sc.nextInt();
			int max = 0;
			int[] input = new int[N];
			for (int n = 0; n < N; n++) {
				input[n] = sc.nextInt();
				if (max < input[n]) {
					max = input[n];
				}
			}
			list = new ArrayList[max + 1];
			visited = new boolean[max + 1];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < input.length - 1; i += 2) {
				list[input[i]].add(input[i + 1]);
			}
			int result = bfs();

			System.out.println("#" + t + " " + result);
		}
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		int max = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			max = 0;
			for (int s = 0; s < size; s++) {
				int cur = q.poll();
				max = Math.max(cur, max);
				for (int j = 0; j < list[cur].size(); j++) {
					int temp = list[cur].get(j);
					if (visited[temp]) {
						continue;
					}
					q.add(temp);
					visited[temp] = true;
				}
			}
		}
		return max;
	}

}
