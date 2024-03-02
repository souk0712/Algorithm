import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ21608_상어초등학교 {

	private static int[][] map;
	private static int N;
	private static int person;
	private static int[] dx = { -1, 0, 0, 1 }; // 상좌우하
	private static int[] dy = { 0, -1, 1, 0 };
	private static boolean[] member;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		person = N * N;
		map = new int[N][N];
		int[] no = new int[person];
		Map<Integer, int[]> position = new HashMap<>();
		member = new boolean[person + 1];
		int[][] like = new int[person + 1][4];

		for (int i = 0; i < person; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			no[i] = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				like[no[i]][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 처리
//		맨 처음 경우 고정 자리에 넣기
		map[1][1] = no[0];
//		맨 처음 경우의 숫자 방문 표시
		member[no[0]] = true;
		position.put(no[0], new int[] { 1, 1 });

		for (int i = 1; i < person; i++) {
			int[][] likePerson = new int[N][N];
			for (int j = 0; j < like[no[i]].length; j++) {
				if (member[like[no[i]][j]]) {
					for (int k = 0; k < dx.length; k++) {
						int[] pos = position.get(like[no[i]][j]);
						int x = pos[0] + dx[k];
						int y = pos[1] + dy[k];
						if (rangeCheck(x, y))
							continue;
						if (map[x][y] != 0)
							continue;
						likePerson[x][y]++;
					}
				}
			}

			int[] maxBlank = new int[] { 0, 0, -1 };
			int max = 0;
			for (int j = 0; j < likePerson.length; j++) {
				for (int k = 0; k < likePerson.length; k++) {
					if (max < likePerson[j][k]) {
						max = likePerson[j][k];
					}
				}
			}

			for (int j = 0; j < likePerson.length; j++) {
				for (int k = 0; k < likePerson.length; k++) {
					if (max == likePerson[j][k] && map[j][k] == 0) {
						int cnt = 0;
						for (int l = 0; l < 4; l++) {
							int x = j + dx[l];
							int y = k + dy[l];
							if (rangeCheck(x, y))
								continue;
							if (map[x][y] != 0)
								continue;
							cnt++;
						}
						if (maxBlank[2] < cnt) {
							maxBlank[0] = j;
							maxBlank[1] = k;
							maxBlank[2] = cnt;
						}
					}
				}
			}
			map[maxBlank[0]][maxBlank[1]] = no[i];
			member[no[i]] = true;
			position.put(no[i], new int[] { maxBlank[0], maxBlank[1] });
		}

		// 만족도 총합 계산
		int ans = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					if (rangeCheck(x, y))
						continue;
					for (int l = 0; l < like[map[i][j]].length; l++) {
						if (like[map[i][j]][l] == map[x][y]) {
							cnt++;
						}
					}
				}
				if (cnt != 0) {
					ans += Math.pow(10, cnt - 1);
				}
			}
		}

		System.out.println(ans);
	}

	private static boolean rangeCheck(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= N)
			return true;
		return false;
	}

}
