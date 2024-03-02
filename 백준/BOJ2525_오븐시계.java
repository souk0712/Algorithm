import java.util.Scanner;

public class BOJ2525_오븐시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int N = sc.nextInt();
		A += (B + N) / 60;
		if (A >= 24)
			A %= 24;
		System.out.println(A + " " + (B + N) % 60);
	}

}
