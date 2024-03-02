import java.util.Scanner;

public class SWEA5607_조합_Fermat_Little_Theorem {

	private static final long P = 1234567891;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int R = sc.nextInt();

			long ans = 0;
			long fac[] = new long[N + 1];
			fac[0] = 1;
			for (int i = 1; i <= N; i++) {
				fac[i] = (fac[i - 1] * i) % P;
			}

			// 페르마의 소정리 a^(p-2) = 1/a (mod P)
			// 조합 nCr = n!/(n-r)!*r!
			long a = fac[N];
			long b = (fac[N - R] * fac[R]) % P;
			long c = pow(b, P - 2);
			ans = a * c % P;

			System.out.println("#" + t + " " + ans);
		}
	}

	public static long pow(long n, long k) {
		if (k == 1) {
			return n;
		}
		long x = pow(n, k / 2) % P;
		if (k % 2 == 0) {
			return x * x % P;
		} else {
			return ((x * x) % P * n) % P;
		}
	}
}
