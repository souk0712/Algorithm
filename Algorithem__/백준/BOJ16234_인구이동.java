import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16234_인구이동 {
	private static int N, L, R;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] map;
	private static int[][] visited;
	private static int[] cntList;	// visited의  num에 맞는 연합 수
	private static int[] sumList;	// visited의  num에 맞는 연합의 합

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		int ans = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 처리
		// 인구이동 실행
		while (true) {
			// 횟수마다 초기화
			visited = new int[N][N];
			sumList = new int[100000];
			cntList = new int[100000];
			int index = 0;	// 임의의 연합 index값
			
			// 연합 나누기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0)
						movementPopulation(i, j, ++index);
				}
			}
			// 연합수가 모든 구역 개수와 같으면 종료
			if (index == N * N) {
				break;
			}
			
			// 각 칸마다의 연합 인구수 구하기
			int[] avgList = new int[index + 1];
			for (int i = 1; i <= index; i++) {
				avgList[i] = sumList[i] / cntList[i];
			}

			// map의 인구수 갱신
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = avgList[visited[i][j]];
				}
			}

			ans++;
		}
		
		// 출력
		System.out.println(ans);

	}

	// DFS
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
