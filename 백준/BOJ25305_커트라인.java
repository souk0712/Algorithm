import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ25305_커트라인 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		Integer[] data = new Integer[N];
		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data, Collections.reverseOrder());
		System.out.println(data[k - 1]);
	}

}
