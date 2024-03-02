import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_낚시터자리잡기_Solution1 {

	private static int N;
	static int[][] idxList = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 1, 0 }, { 2, 0, 1 } }; // 게이트 순서
	private static int ans;
	private static int[][] infos;
	// 경우의 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			infos = new int[3][2];
			StringTokenizer st;
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					infos[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			for (int method = 0; method < 6; method++) { // 게이트 순서
				// 낚시꾼들 자리에 할당하는 기능
				dfs(0, method, new int[N + 1]);
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int dep, int method, int[] posInfo) {
		if (dep == 3) {
			ans = Math.min(ans, calcDisSum(posInfo));
			return;
		}

		int[] newPosInfo = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			newPosInfo[i] = posInfo[i];
		}
		int gate = infos[idxList[method][dep]][0];
		int fisherNum = infos[idxList[method][dep]][1];

		int distance = 0;

		while (fisherNum > 1) { // 2개 이상 남은 경우 계속 수행한다.
			if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
				newPosInfo[gate + distance] = gate;
				fisherNum--;
			}
			if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
				newPosInfo[gate - distance] = gate;
				fisherNum--;
			}
			distance++;
		}
		if (fisherNum == 0) { // fisherNum ==0 인 경우
			dfs(dep + 1, method, newPosInfo);
		} else { // fisherNum ==1인 경우
			distance = findMinDis(gate, newPosInfo);
			if (gate - distance > 0 && newPosInfo[gate - distance] == 0) {
				int[] copy = new int[N + 1];
				for (int i = 0; i <= N; i++)
					copy[i] = newPosInfo[i];
				copy[gate - distance] = gate;
				dfs(dep + 1, method, copy);
			}
			if (gate + distance <= N && newPosInfo[gate + distance] == 0) {
				int[] copy = new int[N + 1];
				for (int i = 0; i <= N; i++)
					copy[i] = newPosInfo[i];
				copy[gate + distance] = gate;
				dfs(dep + 1, method, copy);
			}
		}

	}

	// 게이트별 낚시꾼들을 자리에 할당하는 기능
	static int findMinDis(int gate, int[] posInfo) {
		int leftDis = 0;
		while (gate - leftDis > 0 && posInfo[gate - leftDis] != 0) {
			leftDis++;
		}
		int rightDis = 0;
		while (gate - rightDis > 0 && posInfo[gate - rightDis] != 0) {
			rightDis++;
		}
		int minDis = Math.min(leftDis, rightDis);
		int maxDis = Math.max(leftDis, rightDis);

		return (gate + minDis <= N && posInfo[gate + minDis] == 0) || (gate - minDis > 0 && posInfo[gate - minDis] == 0)
				? minDis
				: maxDis;
	}

	// 자리에 배치된 낚시꾼들의 이동거리를 구하는 기능
	static int calcDisSum(int[] posInfo) {
		int sumDis = 0;
		for (int i = 1; i <= N; i++) {
			if (posInfo[i] != 0) {
				sumDis += Math.abs(posInfo[i] - i) + 1;
			}
		}
		return sumDis;
	}

}
