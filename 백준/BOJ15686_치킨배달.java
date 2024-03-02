import java.util.ArrayList;
import java.util.Scanner;

public class BOJ15686_치킨배달 {
	static int M;
	static ArrayList<int[]> chicken;	// 치킨집 좌표
	static ArrayList<int[]> home;		// 집 좌표
	static int[][] sum;					// 각 집과 치킨 집 사이 치킨 거리
	static int[] pickChicken;			// 뽑힌 치킨집
	static int minSum = 999999;			// 치킨 거리의 최솟값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		pickChicken = new int[M];
		int[][] map = new int[N][N];
		
		// 치킨집, 집 좌표 채우기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					home.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		// 각 집과 치킨 집 사이 치킨 거리 채우기
		sum = new int[chicken.size()][home.size()];
		for (int i = 0; i < chicken.size(); i++) {
			int[] chi = chicken.get(i);
			for (int j = 0; j < home.size(); j++) {
				int[] ho = home.get(j);
				sum[i][j] = Math.abs(chi[0] - ho[0]) + Math.abs(chi[1] - ho[1]);
			}
		}
		comb(0, 0);		// 치킨 집 중 M개의 치킨 집 뽑기

		System.out.println(minSum);
	}

	static void comb(int cnt, int start) {
		if (cnt == M) {
			// 뽑힌 치킨집 중 집마다 치킨거리의 최솟값 구하고, temp에 합을 구해 minSum과 비교 후 최솟값 구하기
			int temp = 0;
			for (int i = 0; i < home.size(); i++) {
				int min = 999999;
				for (int j = 0; j < M; j++) {
					if (min > sum[pickChicken[j]][i]) {
						min = sum[pickChicken[j]][i];
					}
				}
				temp += min;
			}
			if (minSum > temp) {
				minSum = temp;
			}
			return;
		}
		for (int i = start; i < chicken.size(); i++) {
			pickChicken[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}
