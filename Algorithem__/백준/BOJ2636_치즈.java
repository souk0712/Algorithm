import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636_치즈 {

	private static int H;
	private static int W;
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					count++;
				}
			}
		}
		int time = 0;
		while (true) {
			findAir(0, 0);
			meltCheese();
			boolean flag = true;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				break;
			deleteCheese();
			time++;
		}
		System.out.println(time + 1);
		System.out.println(count);
	}

	private static void deleteCheese() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 5) {
					count--;
					map[i][j] = 3;
				}
			}
		}
	}

	private static void meltCheese() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 1) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int k = 0; k < 4; k++) {
				int x = p[0] + dx[k];
				int y = p[1] + dy[k];
				if (x < 0 || y < 0 || x >= H || y >= W)
					continue;
				if (map[x][y] == 3) {
					map[p[0]][p[1]] = 5; // 녹을 치즈
					break;
				}
			}
		}

	}

	private static void findAir(int i, int j) {
		boolean[][] visited = new boolean[H][W];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j });
		visited[i][j] = true;
		map[i][j] = 3;
		while (!q.isEmpty()) {
			int[] p = q.poll();

			for (int k = 0; k < 4; k++) {
				int x = p[0] + dx[k];
				int y = p[1] + dy[k];
				if (x < 0 || y < 0 || x >= H || y >= W)
					continue;
				if (map[x][y] == 1)
					continue;
				if (visited[x][y])
					continue;
				q.add(new int[] { x, y });
				visited[x][y] = true;
				map[x][y] = 3;
			}
		}

	}
}
