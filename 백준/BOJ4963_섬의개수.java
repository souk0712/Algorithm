import java.util.Scanner;

public class BOJ4963_섬의개수 {
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, 1, -1, -1, 1 };
	static boolean[][] visited;
	static int w, h;
	private static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			visited = new boolean[h][w];
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visited[i][j] || map[i][j] == 0)
						continue;
					dfs(i, j);
					count++;
				}
			}
			System.out.println(count);
		}
	}

	public static void dfs(int i, int j) {
		if (visited[i][j] || map[i][j] == 0)
			return;
		visited[i][j] = true;
		for (int k = 0; k < dx.length; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			if (x < 0 || x >= h || y < 0 || y >= w)
				continue;
			if (map[x][y] == 0)
				continue;
			dfs(x, y);
		}

	}

}
