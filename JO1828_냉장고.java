import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JO1828_냉장고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		Temperature[] temps = new Temperature[N];
		for (int i = 0; i < N; i++) {
			temps[i] = new Temperature(sc.nextInt(), sc.nextInt());
		}
		int ans = getRefrigerator(N, temps);
		System.out.println(ans);

	}

	private static int getRefrigerator(int n, Temperature[] temps) {
		List<Temperature> result = new ArrayList<Temperature>();
		Arrays.sort(temps);
		result.add(temps[0]);

		for (int i = 1; i < temps.length; i++) {
			if (result.get(result.size() - 1).y < temps[i].x) {
				result.add(temps[i]);
			}
		}
		return result.size();
	}

	static class Temperature implements Comparable<Temperature> {
		int x;
		int y;

		public Temperature(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Temperature o) {
			if (this.y == o.y) {
				return Integer.compare(this.x, o.x);
			} else {
				return Integer.compare(this.y, o.y);
			}
		}

	}
}
