import java.util.Scanner;

public class SWEA3238이항계수구하기_Fermat_Little_Theorem {
	private static long P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long N = sc.nextLong();
			long R = sc.nextLong();
			P = sc.nextLong();

			long ans = 1;
			long fac[] = new long[(int) (P + 1)];
			fac[0] = 1;
			for (int i = 1; i < P + 1; i++) {
				fac[i] = (fac[i - 1] * i) % P;
			}

			// 뤼카의 정리
			while (N > 0 || R > 0) {
				int a = (int) (N % P);
				int b = (int) (R % P);
				if (b > a) {
					ans = 0;
					break;
				}
				// 페르마의 소정리
				ans = (ans * fac[a]) % P;
				for (int i = 0; i < P - 2; i++) {
					ans = (ans * fac[a - b] * fac[b]) % P;
				}
				N /= P;
				R /= P;
			}

			System.out.println("#" + t + " " + ans % P);
		}
	}
}
