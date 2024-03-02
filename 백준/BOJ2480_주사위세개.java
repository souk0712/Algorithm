import java.util.Scanner;

public class BOJ2480_주사위세개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[3];
		int max = 0;
		for (int i = 0; i < 3; i++) {
			input[i] = sc.nextInt();
			max = Math.max(input[i], max);
		}
		int cnt = 1;
		int same=0;
		for (int i = 0; i < 3; i++) {
			int temp = input[i];
			for (int j = i + 1; j < 3; j++) {
				if (temp == input[j]) {
					cnt++;
					same=input[j];
				}
			}
		}
		int ans = 0;
		switch (cnt) {
		case 4:
			ans = 10000 + same * 1000;
			break;
		case 2:
			ans = 1000 + same * 100;
			break;
		case 1:
			ans = max * 100;
			break;
		}
		System.out.println(ans);

	}

}
