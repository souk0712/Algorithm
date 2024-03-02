import java.util.Scanner;

public class BOJ1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		int cnt = 0;
		int value = 666;

		while (cnt != N) {
			if (Integer.toString(value).contains("666")) {
				cnt++;
				ans = value;
			}
			value++;
		}
		System.out.println(ans);
	}
}
