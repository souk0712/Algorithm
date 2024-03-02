import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1920_수찾기 {

	private static int N;
	private static int M;
	private static int[] arrN;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		N = sc.nextInt();

		arrN = new int[N];
		for (int i = 0; i < N; i++) {
			pq.offer(sc.nextInt());
		}
		int k = 0;
		while (!pq.isEmpty()) {
			arrN[k++] = pq.poll();
		}
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			if (binarySearch(num)) {
				sb.append(1).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static boolean binarySearch(int num) {
		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int midValue = arrN[mid];
			if (num == midValue) {
				return true;
			} else if (num > midValue) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}