import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] p = new int[N];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}

		Arrays.sort(p);
		int sum = 0;
		int idx = p.length;
		while (idx >= 0) {
			for (int i = 0; i < idx; i++) {
				sum += p[i];
			}
			idx--;
		}

		System.out.println(sum);

	}

}
