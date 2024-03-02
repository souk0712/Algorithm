import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int M;
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static ArrayList<Virus> virusList;
	private static int emptyCnt;
	private static boolean[] visit;
	private static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virusList = new ArrayList<>();
		emptyCnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					emptyCnt++;
				}
				if (map[i][j] == 2) {
					virusList.add(new Virus(i, j));
				}
			}
		}
		visit = new boolean[virusList.size()];

		dfs(0, 0);

		System.out.println(result == Integer.MAX_VALUE ? -1 : result);

	}

	private static void dfs(int start, int count) {
		if (count == M) {
			result = Math.min(result, spreadVirus());
			return;
		}
		for (int i = start; i < virusList.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i + 1, count + 1);
				visit[i] = false;
			}
		}

	}

	private static int spreadVirus() {
		Queue<Virus> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < virusList.size(); i++) {
			if (visit[i]) {
				q.add(new Virus(virusList.get(i).x, virusList.get(i).y, 0));
			}
		}

		int value = 0;
		int zeroCnt = 0;

		while (!q.isEmpty()) {
			Virus v = q.poll();
			int qx = v.x;
			int qy = v.y;
			int qt = v.time;

			for (int i = 0; i < 4; i++) {
				int nx = qx + dx[i];
				int ny = qy + dy[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;
				if (map[nx][ny] == 1 || visited[nx][ny])
					continue;
				if (map[nx][ny] == 0) {
					zeroCnt++;
					value = qt + 1;
				}

				visited[nx][ny] = true;
				q.add(new Virus(nx, ny, qt + 1));
			}

		}

		if (zeroCnt == emptyCnt) {
			return value;
		}
		return Integer.MAX_VALUE;

	}

	static class Virus {
		int x, y, time;

		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Virus(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Virus [x=" + x + ", y=" + y + ", time=" + time + "]";
		}

	}
}
