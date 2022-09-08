import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_빵집 {

	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][] visited;
	private static int ans;
	private static int[] dx = { -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			pipe(i, 0);
		}
		System.out.println(ans);
	}

	private static boolean pipe(int i, int j) {

		for (int k = 0; k < dx.length; k++) {
			int x = i + dx[k];
			int y = j + 1;
			if (x < 0 || x >= R || y < 0 || y >= C)
				continue;
			if (map[x][y] == 'x' || visited[x][y])
				continue;
			if (y == C - 1) {
				ans++;
				return true;
			}
			visited[x][y] = true;
			if (pipe(x, y)) {
				return true;
			}
		}
		return false;
	}

}
