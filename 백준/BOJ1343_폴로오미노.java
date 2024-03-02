import java.util.Scanner;

public class BOJ1343_폴로오미노 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] temp = sc.next().toCharArray();
		char[] input = new char[temp.length + 1];
		for (int i = 0; i < temp.length; i++) {
			input[i] = temp[i];
		}
		int count = 0;
		String ans = "";
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'X') {
				count++;
			} else {
				if (count % 2 != 0) {
					System.out.println(-1);
					return;
				} else {
					int num = count;
					while (num >= 4) {
						num -= 4;
						ans += "AAAA";
					}
					if (num != 0) {
						ans += "BB";
					}
					if (input.length - 1 != i)
						ans += input[i];
					count = 0;
				}
			}
		}
		System.out.println(ans);

	}

}
