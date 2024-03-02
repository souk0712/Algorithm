
public class BOJ4673_셀프넘버 {

	private static boolean[] number;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		number = new boolean[10050];
		number[0] = true;
		d(1);
		for (int i = 0; i <= 10000; i++) {
			if (!number[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}

	private static void d(int i) {
		if (i > 10000) {
			return;
		}
		int sum = 0;
		if (i < 10) {
			sum = i + i;
		} else if (10 <= i && i < 100) {
			sum = i + i / 10 + i % 10;
		} else if (100 <= i && i < 1000) {
			int temp = i;
			int hun = temp / 100;
			temp %= 100;
			int ten = temp / 10;
			sum = i + hun + ten + temp % 10;

		} else if (1000 <= i && i < 10000) {
			int temp = i;
			int thou = i / 1000;
			temp %= 1000;
			int hun = temp / 100;
			temp %= 100;
			int ten = temp / 10;
			sum = i + thou + hun + ten + temp % 10;
		}
		number[sum] = true;
		d(i + 1);
	}

}
