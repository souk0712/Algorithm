import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int[][] map;
	private static int N;
	private static int L;
	private static int R;
	private static int[][] visited;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int ans;
	private static int[] cntList;
	private static int[] sumList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			visited = new int[N][N];
			sumList = new int[100000];
			cntList = new int[100000];
			int num = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0)
						movementPopulation(i, j, ++num);
				}
			}
			if (num == N * N) {
				break;
			}
			int[] avgList = new int[num + 1];
			for (int i = 1; i <= num; i++) {
				avgList[i] = sumList[i] / cntList[i];
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = avgList[visited[i][j]];
				}
			}

			ans++;
		}
		System.out.println(ans);

	}

	private static void movementPopulation(int i, int j, int num) {
		visited[i][j] = num;
		sumList[num] += map[i][j];
		cntList[num]++;
		for (int k = 0; k < dx.length; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x < 0 || x >= N || y < 0 || y >= N)
				continue;
			if (visited[x][y] != 0)
				continue;
			int diff = Math.abs(map[i][j] - map[x][y]);

			if (diff < L || diff > R)
				continue;

			movementPopulation(x, y, num);
		}
	}

}
