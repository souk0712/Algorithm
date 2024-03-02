import java.util.Scanner;

public class BOJ15652_N과M4 {

	private static int M;
	private static int N;
	private static int[] pick;
	private static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		pick = new int[M];
		sb = new StringBuilder();

		comb(0, 1);
		System.out.println(sb);

	}

	private static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int i = 0; i < pick.length; i++) {
				sb.append(pick[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			pick[cnt] = i;
			comb(cnt + 1, i);
		}

	}

}
