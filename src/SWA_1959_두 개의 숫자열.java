package algo_1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWA_1959 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		int N, M;
		int[] a, b;
		for (int t = 1; t <= T; t++) {
			 st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			a = new int[N];
			b = new int[M];

			fillString(a);
			fillString(b);

			int ans;
			if (N < M) {
				ans = returnMax(a, b, N, M);
			} else {
				ans = returnMax(b, a, M, N);
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	static int returnMax(int[] a, int[] b, int n, int m) {
		int max = 0;
		for (int i = 0; i <= m - n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += a[j] * b[j + i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	static void fillString(int[] arr) throws IOException {
		 st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
	}

}
