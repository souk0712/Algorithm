import java.util.Scanner;

public class BOJ20361_일우는야바위꾼 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int X = sc.nextInt();
		int K = sc.nextInt();
		int ball = X;
		for (int i = 0; i < K; i++) {
			int to = sc.nextInt();
			int from = sc.nextInt();
			if (to == ball) {
				ball = from;
			} else if (from == ball) {
				ball = to;
			}
		}
		System.out.println(ball);
	}
}
