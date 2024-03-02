import java.util.Scanner;

public class BOJ2231_분해합 {

	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		digitGenerator();

	}

	private static void digitGenerator() {
		int res = N;
		for (int i = 1; i <= N; i++) {
			if (i < 10) {
				res = i + i;

			} else if (i >= 10 && i < 100) {
				int tmp = i;
				int ten = tmp / 10;
				tmp %= 10;
				res = i + ten + tmp;

			} else if (i >= 100 && i < 1_000) {
				int tmp = i;
				int hun = tmp / 100;
				tmp %= 100;
				int ten = tmp / 10;
				tmp %= 10;
				res = i + hun + ten + tmp;
			} else if (i >= 1_000 && i < 10_000) {
				int tmp = i;
				int thous = tmp / 1000;
				tmp %= 1000;
				int hun = tmp / 100;
				tmp %= 100;
				int ten = tmp / 10;
				tmp %= 10;
				res = i + thous + hun + ten + tmp;
			} else if (i >= 10_000 && i < 100_000) {
				int tmp = i;
				int tThous = tmp / 10000;
				tmp %= 10000;
				int thous = tmp / 1000;
				tmp %= 1000;
				int hun = tmp / 100;
				tmp %= 100;
				int ten = tmp / 10;
				tmp %= 10;
				res = i + tThous + thous + hun + ten + tmp;
			} else if (i >= 100_000 && i < 1_000_000) {
				int tmp = i;
				int hThous = tmp / 100000;
				tmp %= 100000;
				int tThous = tmp / 10000;
				tmp %= 10000;
				int thous = tmp / 1000;
				tmp %= 1000;
				int hun = tmp / 100;
				tmp %= 100;
				int ten = tmp / 10;
				tmp %= 10;
				res = i + hThous + tThous + thous + hun + ten + tmp;
			}
			if (res == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
