import java.util.Scanner;

public class SWEA3307_최장증가부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1)
						LIS[i] = LIS[j] + 1;
				}
			}

			int max = LIS[0];
			for (int i = 1; i < LIS.length; i++) {
				max = Math.max(LIS[i], max);
			}
			System.out.println("#" + t + " " + max);
		}
	}

}
