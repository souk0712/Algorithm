package algo_waterStrider;

import java.util.Arrays;
import java.util.Scanner;

public class waterStrider {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		int N, num; // 연못 크기, 소금쟁이 수
		boolean[][] map; // 연못에 소금쟁이 여부
		int[][] state; // 소금쟁이 위치와 방향
		boolean[] dead; // 소금쟁이가 죽었는지 확인
		int[] dx = { -1, 1, 0, 0 }; // 상, 하, 좌, 우
		int[] dy = { 0, 0, -1, 1 };

		for (int t = 1; t <= T; t++) {
			// 입력
			N = sc.nextInt();
			num = sc.nextInt();
			int count = num;
			state = new int[num][3];
			map = new boolean[N][N];
			dead = new boolean[num];
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < 3; j++) {
					state[i][j] = sc.nextInt();
				}
				// 소금쟁이가 연못 밖이면 죽음.
				if (state[i][0] < 0 || state[i][0] >= N || state[i][1] < 0 || state[i][1] >= N) {
					count--;
					dead[i] = true;
					continue;
				}
				// 소금쟁이 있으면 true
				map[state[i][0]][state[i][1]] = true;
			}

			// 소금쟁이가 들어온 순서대로 3번 한꺼번에 뜀.
			for (int j = 0; j < num; j++) {
				// 3번 뛰기
				for (int a = 3; a > 0; a--) {
					// 소금쟁이가 죽었으면 돌아감.
					if (dead[j])
						continue;
					int x = state[j][0] + dx[state[j][2] - 1] * a;
					int y = state[j][1] + dy[state[j][2] - 1] * a;
					// 소금쟁이가 연못 밖에 나가면 죽음. 그 전에 있던 자리에 false를 놓음.
					if (x < 0 || x >= N || y < 0 || y >= N) {
						count--;
						dead[j] = true;
						map[state[j][0]][state[j][1]] = false;
						continue;
					}
					// 1,2,3번 뛰는 도중 다른 소금쟁이가 있으면 죽음.
					if (map[x][y]) {
						count--;
						dead[j] = true;
						map[state[j][0]][state[j][1]] = false;
						continue;
					}
					// 무사히 뛰면 그자리에 머물러서 true
					map[x][y] = true;
					// 그전에 있던 자리는 false
					map[state[j][0]][state[j][1]] = false;
					// 이동된 장소를 state에 저장
					state[j][0] = x;
					state[j][1] = y;
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}
}
