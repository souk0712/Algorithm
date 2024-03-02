import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2606_바이러스 {
	static ArrayList<Integer>[] list;
	private static boolean[] visited;
	private static int N;
	private static int M;
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list[start].add(end);
			list[end].add(start);
		}
		visited = new boolean[N + 1];
		count = 0;

		virus(1);
		System.out.println(count-1);
	}

	private static void virus(int start) {
		if (visited[start])
			return;
		visited[start] = true;
		count++;
		for (int i = 0; i < list[start].size(); i++) {
			virus(list[start].get(i));
		}

	}

}
