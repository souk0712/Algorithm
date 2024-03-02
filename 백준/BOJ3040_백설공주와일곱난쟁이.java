import java.util.Scanner;

public class BOJ3040_백설공주와일곱난쟁이 {

	private static int[] kko;
	private static int[] pick;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		kko = new int[9];
		pick = new int[7];
		for (int i = 0; i < 9; i++) {
			kko[i] = sc.nextInt();
		}
		comb(0, 0);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int k : pick) {
				sum += k;
			}
			if (sum == 100) {
				for (int k : pick) {
					System.out.println(k);
				}
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			pick[cnt] = kko[i];
			comb(cnt + 1, i + 1);
		}
	}

}
