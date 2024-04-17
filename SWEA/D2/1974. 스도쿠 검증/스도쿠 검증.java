import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을 경우 0 을 출력한다.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		out: for (int t = 0; t < T; t++) {
			sb.append("#").append(t + 1).append(" ");
			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
				}
			}
			for (int i = 0; i < 9; i++) {
				boolean[] visit = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (visit[map[i][j]]) {
						sb.append(0).append("\n");
						continue out;
					}
					visit[map[i][j]] = true;

				}
			}

			for (int i = 0; i < 9; i++) {
				boolean[] visit = new boolean[10];
				for (int j = 0; j < 9; j++) {
					if (visit[map[j][i]]) {
						sb.append(0).append("\n");
						continue out;
					}
					visit[map[j][i]] = true;

				}
			}
			for (int i = 0; i < 9; i += 3) {
				for (int j = 0; j < 9; j += 3) {
					boolean[] visit = new boolean[10];
					for (int k = i; k < i + 3; k++) {
						for (int l = j; l < j + 3; l++) {
							if (visit[map[k][l]]) {
								sb.append(0).append("\n");
								continue out;
							}
							visit[map[k][l]] = true;
						}
					}
				}
			}
			sb.append(1).append("\n");
		}
		System.out.println(sb);
	}
}