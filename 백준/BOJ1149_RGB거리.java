import java.util.Scanner;

public class BOJ1149_RGB거리 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] map = new int[N][3];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int[][] sum = new int[N + 1][3];
		for (int i = 1; i < sum.length; i++) {
			sum[i][0] = Math.min(sum[i - 1][1], sum[i - 1][2]) + map[i - 1][0];
			sum[i][1] = Math.min(sum[i - 1][0], sum[i - 1][2]) + map[i - 1][1];
			sum[i][2] = Math.min(sum[i - 1][0], sum[i - 1][1]) + map[i - 1][2];
		}

		int min = 999999;
		for (int i = 0; i < 3; i++) {
			if (min > sum[sum.length - 1][i])
				min = sum[sum.length - 1][i];
		}
		System.out.println(min);
	}

}
