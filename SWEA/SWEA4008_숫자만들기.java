import java.util.Scanner;

public class SWEA4008_숫자만들기 {

	private static int max;
	private static int min;
	private static int N;
	private static int[] oper;
	private static int[] num;
	private static int[] pickOper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			oper = new int[4];
			num = new int[N];
			// '+', '-', '*', '/'
			for (int n = 0; n < 4; n++) {
				oper[n] = sc.nextInt();
			}
			for (int n = 0; n < N; n++) {
				num[n] = sc.nextInt();
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			pickOper = new int[N - 1];

			calc(0);

			sb.append("#").append(t).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
	}

	private static void calc(int cnt) {
		if (cnt == N - 1) {
			int res = num[0];
			for (int o = 0, n = 1; o < pickOper.length; o++) {
				switch (pickOper[o]) {
				case 0:
					res += num[n++];
					break;
				case 1:
					res -= num[n++];
					break;
				case 2:
					res *= num[n++];
					break;
				case 3:
					res /= num[n++];
					break;
				}

			}
			if (min > res) {
				min = res;
			}
			if (max < res) {
				max = res;
			}
			return;
		}
		for (int i = 0; i < oper.length; i++) {
			if (oper[i] > 0) {
				pickOper[cnt] = i;
				oper[i]--;
				calc(cnt + 1);
				oper[i]++;
			}
		}

	}

}
