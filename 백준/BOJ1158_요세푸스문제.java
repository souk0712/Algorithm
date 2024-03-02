import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ1158_요세푸스문제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] ans = new int[N];
		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int i = 0;
		while (!list.isEmpty()) {
			index = (index + K - 1) % list.size();
			ans[i++] = list.remove(index);
		}
		sb.append("<");
		for (int j = 0; j < ans.length; j++) {
			if (j == ans.length - 1)
				sb.append(ans[j]);
			else
				sb.append(ans[j] + ", ");
		}
		sb.append(">");
		System.out.println(sb);
	}

}
