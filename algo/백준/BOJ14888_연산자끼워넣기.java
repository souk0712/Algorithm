import java.util.ArrayList;
import java.util.Scanner;

public class BOJ14888_연산자끼워넣기 {

	private static int[] operatorCnt;
	private static int N;
	private static int[] a;
	private static ArrayList<Character> operator;
	private static boolean[] selected;
	private static char[] pick;
	private static int max;
	private static int min;
	private static int total;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		operatorCnt = new int[4];

		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		total = 0;
		for (int i = 0; i < operatorCnt.length; i++) {
			operatorCnt[i] = sc.nextInt();
			total += operatorCnt[i];
		}
		operator = new ArrayList<Character>();
		selected = new boolean[total];
		pick = new char[total];
		for (int i = 0; i < operatorCnt.length; i++) {
			for (int j = 0; j < operatorCnt[i]; j++) {
				switch (i) {
				case 0:
					operator.add('+');
					break;
				case 1:
					operator.add('-');
					break;
				case 2:
					operator.add('*');
					break;
				case 3:
					operator.add('/');
					break;
				}
			}
		}
		perm(0);
		System.out.println(max);
		System.out.println(min);

	}

	private static void perm(int cnt) {
		if (cnt == total) {
			int sum;
			sum = a[0];
			for (int i = 0, j = 0; i < pick.length; i++, j++) {
				switch (pick[i]) {
				case '+':
					sum += a[j + 1];
					break;
				case '-':
					sum -= a[j + 1];
					break;
				case '*':
					sum *= a[j + 1];
					break;
				case '/':
					sum /= a[j + 1];
					break;
				}
			}
			if (max < sum) {
				max = sum;
			}
			if (min > sum) {
				min = sum;
			}
		}
		for (int i = 0; i < total; i++) {
			if (selected[i])
				continue;
			pick[cnt] = operator.get(i);
			selected[i] = true;
			perm(cnt + 1);
			selected[i] = false;
		}

	}

}
