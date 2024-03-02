import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20299_3대측정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 출력을 위한 버퍼
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력을 띄어쓰기 기준으로 나눔
		int N = Integer.parseInt(st.nextToken()); // 신청한 동아리 수
		int S = Integer.parseInt(st.nextToken()); // 팀원 3명의 능력 합에 대한 스마트클럽 가입조건
		int M = Integer.parseInt(st.nextToken()); // 개인 능력치에 대한 스마트클럽 가입조건

		int ansCnt = 0; // 가입 가능한 동아리 수
		Queue<int[]> q = new LinkedList<>(); // 가입된 동아리의 능력들
		int[][] input = new int[N][3]; // 신청한 동아리의 능력
		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); // 입력을 띄어쓰기 기준으로 나눔
			for (int j = 0; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 처리
		loop: for (int i = 0; i < N; i++) {
			long sum = 0; // 동아리별 능력의 합
			for (int j = 0; j < 3; j++) {
				if (input[i][j] < M) // 개인의 능력이 M미만인 경우 탈락
					continue loop;
				sum += input[i][j]; // 개인의 능력이 M이상인 경우만 능력합 구하기
			}
			if (sum < S) // 동아리별 능력의 합이 S미만인 경우 탈락
				continue loop;
			ansCnt++; // 동아리별 능력의 합이 S이상인 경우 카운트 증가
			q.offer(input[i]); // 동아리별 능력의 합이 S이상인 경우 큐에 넣기
		}

		// 출력을 위한 버퍼에 저장
		sb.append(ansCnt).append("\n");
		while (!q.isEmpty()) {
			int[] p = q.poll(); // 큐에서 가입 가능한 동아리별로 능력들 추출
			for (int j = 0; j < p.length; j++) {
				sb.append(p[j]).append(" "); // 가입 가능한 동아리별 능력 버퍼에 저장
			}
		}
		// 출력
		System.out.println(sb);
	}
}
