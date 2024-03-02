import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ2468_안전영역 {

	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int maxHeight;
	private static ArrayList<int[]> arrayList;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		maxHeight = 0;
		int max = 1;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
				if (maxHeight < map[i][j]) {
					maxHeight = map[i][j];
				}
			}
		}


		for (int h = 1; h <= maxHeight; h++) {
			visited = new boolean[N][N];
			arrayList = new ArrayList<>();
			int res = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= h) {
						visited[i][j] = true;
					} else {
						arrayList.add(new int[] { i, j });
					}
				}
			}

			for (int k = 0; k < arrayList.size(); k++) {
				int[] temp = arrayList.get(k);
				if (visited[temp[0]][temp[1]])
					continue;
				dfs(temp[0], temp[1]);
				res++;
			}
			if (max < res) {
				max = res;
			}
		}
		System.out.println(max);
	}

	private static void dfs(int i, int j) {
		if (visited[i][j])
			return;
		visited[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x < 0 || x >= N || y < 0 || y >= N) {
				continue;
			}
			dfs(x, y);
		}
	}
}
