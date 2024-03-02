import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026_적록색약 {

	private static int[][] visit;
	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 };
	private static int N;
	private static char[][] map;
	private static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visit = new int[N][N];
		int num = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (visit[i][j] == 0) {
					bfs(i, j, num, true);
					num++;
				}
			}
		}

		visit = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		num = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (visit[i][j] == 0) {
					bfs(i, j, num, false);
					num++;
				}
			}
		}
		System.out.println(A + " " + B);
	}

	private static void bfs(int i, int j, int num, boolean flag) {
		char target = map[i][j];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { i, j });
		visit[i][j] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < dx.length; k++) {
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				if (x < 0 || x >= N || y < 0 || y >= N)
					continue;
				if (map[x][y] != target || visit[x][y] == num)
					continue;
				q.add(new int[] { x, y });
				visit[x][y] = num;
			}
		}
		if (flag)
			A++;
		else
			B++;
	}
}