import java.util.Arrays;
import java.util.Scanner;

public class SWEA3308_최장증가부분수열_hard {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] C = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int size = 0;
			for (int i = 0; i < N; i++) {
				int pos = Arrays.binarySearch(C, 0, size, arr[i]);
				if (pos >= 0)
					continue;
				pos = Math.abs(pos) - 1;
				C[pos] = arr[i];
				if (pos == size) {
					size++;
				}
			}

			System.out.println("#" + t + " " + size);
		}
	}

}
