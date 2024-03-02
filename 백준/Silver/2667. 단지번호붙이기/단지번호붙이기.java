import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	private static int[][] map;
	private static int N;
	private static int[][] visited;
	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 };

	private static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 0 && visited[i][j] != 1)
					bfs(i, j);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(pq.size() + "\n");
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + "\n");
		}

		System.out.print(sb);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		int count = 1;
		visited[i][j] = 1;
		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (int k = 0; k < dx.length; k++) {
				int x = current[0] + dx[k];
				int y = current[1] + dy[k];
				if (x < 0 || x >= N || y < 0 || y >= N)
					continue;
				if (map[x][y] == 0 || visited[x][y] == 1)
					continue;
				q.add(new int[] { x, y });
				visited[x][y] = 1;
				count++;
			}
		}
		pq.offer(count);
	}
}