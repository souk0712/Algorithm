import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BOJ15961_회전초밥 {

	private static int N, d, k, c;
	private static Deque<Integer> dQueue;
	private static int[] sushi;
	private static int[] sushiList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		c = sc.nextInt();

		dQueue = new ArrayDeque<>();
		sushi = new int[N];
		sushiList = new int[d + 1];
		for (int i = 0; i < N; i++) {
			sushi[i] = sc.nextInt();
		}

		int cnt = 0;
		int result = 0;
		for (int i = 0; i < k; i++) {
			dQueue.offer(sushi[i]);
			if (sushiList[sushi[i]]++ == 0) {
				cnt++;
			}
		}
		result = Math.max(cnt, result);

		for (int i = 0; i < N - 1; i++) {
			dQueue.pollFirst();

			if (--sushiList[sushi[i]] == 0) {
				cnt--;
			}

			dQueue.offer(sushi[(i + k) % N]);

			if (sushiList[sushi[(i + k) % N]]++ == 0) {
				cnt++;
			}
			if (sushiList[c] != 0) {
				result = Math.max(cnt, result);
			} else {
				result = Math.max(cnt + 1, result);
			}
		}

		System.out.println(result);

	}
}
