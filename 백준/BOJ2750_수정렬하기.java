package algo_BJ_2750;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2750_수정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		for(int i : num) {
			System.out.println(i);
		}
	}

}
