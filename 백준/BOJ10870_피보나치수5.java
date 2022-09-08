import java.util.Scanner;

public class BOJ10870_피보나치수5 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		System.out.println(fibo(N));
	}

	static int fibo(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibo(n - 1) + fibo(n - 2);
	}

}
