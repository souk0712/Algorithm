import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502_연구소 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (map[i][j] == 0) {
//					makeWall(0, 0, 0);
//				}
//			}
//		}
		makeWall(0);
		System.out.println(max);
	}

	private static void copyMap(int[][] map, int[][] newMap) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newMap[i][j] = map[i][j];
			}
		}
	}

	private static void makeWall(int cnt) {
		if (cnt == 3) {
			spreadVirus();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	private static int safeArea(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void spreadVirus() {
		int[][] tmp = new int[N][M];
		copyMap(map, tmp);
		Queue<int[]> q = new LinkedList<>();
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (tmp[r][c] == 2) {
					q.add(new int[] { r, c });
				}
			}
		}
		while (!q.isEmpty()) {
			int[] poll = q.poll();
			tmp[poll[0]][poll[1]] = 2;
			for (int k = 0; k < 4; k++) {
				int x = poll[0] + dx[k];
				int y = poll[1] + dy[k];
				if (x < 0 || x >= N || y < 0 || y >= M)
					continue;
				if (tmp[x][y] == 0) {
					q.add(new int[] { x, y });
				}
			}
		}
		int res = safeArea(tmp);
		max = Math.max(max, res);
	}

}
