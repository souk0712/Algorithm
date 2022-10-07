import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1082_화염에서탈출 {
	final static String IMPOS = "impossible";
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static char[][] map;
	private static int[][] time;
	private static int M;
	private static int N;
	private static Position su;
	private static Position god;
	private static int min;
	private static Queue<Position> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = 9999999;

		map = new char[N][M];
		time = new int[N][M];
		q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'S') {
					su = new Position(i, j);
				}
				if (map[i][j] == 'D') {
					god = new Position(i, j);
				}
				if (map[i][j] == '*') {
					q.add(new Position(i, j));
				}
			}
		}

		DevMove();
		int sec = suMove();
		if (sec == -1)
			sb.append(IMPOS);
		else
			sb.append(sec);
		System.out.println(sb);

	}

	private static void DevMove() {
		int sec = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Position dev = q.poll();
				time[dev.x][dev.y] = sec;

				for (int k = 0; k < 4; k++) {
					int x = dev.x + dx[k];
					int y = dev.y + dy[k];
					if (x < 0 || y < 0 || x >= N || y >= M)
						continue;
					if (map[x][y] == 'X' || map[x][y] == 'D' || time[x][y] != 0)
						continue;
					q.add(new Position(x, y));
					time[x][y] = sec;
				}
			}
			sec++;
		}
	}

	private static int suMove() {
		Queue<Position> q = new LinkedList<>();
		int sec = 1;
		time[god.x][god.y] = Integer.MAX_VALUE;
		q.add(su);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Position nsu = q.poll();
				if (nsu.x == god.x && nsu.y == god.y) {
					return sec - 1;
				}
				for (int k = 0; k < 4; k++) {
					int x = nsu.x + dx[k];
					int y = nsu.y + dy[k];
					if (x < 0 || y < 0 || x >= N || y >= M)
						continue;
					if (map[x][y] == '*' || map[x][y] == 'X' || map[x][y] == 'S')
						continue;
					if (time[x][y] == 0 || time[x][y] > sec + 1) {
						q.add(new Position(x, y));
						map[x][y] = 'S';

					}
				}
			}
			sec++;
		}
		return -1;
	}

	static class Position {
		int x, y;

		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}

	}
}
