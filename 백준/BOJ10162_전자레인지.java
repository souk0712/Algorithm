import java.util.Scanner;

public class BOJ10162_전자레인지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] abc = { 300, 60, 10 };
		int[] count = new int[3];

		int index = 0;
		while (index < 3) {
			if (T >= abc[index]) {
				T -= abc[index];
				count[index]++;

			} else {
				index++;
			}
		}
		if (T != 0) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < count.length; i++) {
			System.out.print(count[i] + " ");
		}
	}

}
