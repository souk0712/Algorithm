import java.util.Scanner;

public class BOJ2559_수열 {

	private static int[] input;
	private static int N;
	private static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		input = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
			if (i < K) {
				sum += input[i];
			}
		}
		// 슬라이딩 윈도우로 특정구역을 더하거나 뺴는 방식 적용
		int max = sum;
		for (int i = 1; i <= N - K; i++) {
			sum -= input[i - 1];
			sum += input[i + K - 1];

			max = Math.max(sum, max);
		}

		System.out.println(max);

	}

}
