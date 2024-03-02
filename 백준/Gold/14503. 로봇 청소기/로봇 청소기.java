import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] map;
	static int N, M;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int cleanCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		while (st.hasMoreElements()) {
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		map = new int[N][M];
		int cx = 0, cy = 0, d = 0;
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreElements()) {
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreElements()) {
				map[i][j++] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		cleanCnt = 1;
		while (true) {
			if (count == 4) {
				int x = cx + dx[(d + 4 - 1) % 4];
				int y = cy + dy[(d + 4 - 1) % 4];
				if (map[x][y] == 1) {
					break;
				}
				cx = x;
				cy = y;
				count = 0;
			}
			visited[cx][cy] = true;
			int x = cx + dx[d];
			int y = cy + dy[d];

			if (map[x][y] == 1 || visited[x][y]) {
				count++;
			} else {
				
				count = 0;
				cleanCnt++;
				cx = x;
				cy = y;

			}
			d = (d + 4 - 1) % 4;
		}
		System.out.println(cleanCnt);
	}
}