import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17143_낚시왕 {

	private static int R;
	private static int C;
	private static int M;
	private static ArrayList<Shark> sharks;
	private static int sum;
	private static int[] dx = { 0, -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, 0, 1, -1 };
	private static Shark[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new ArrayList<>();
		map = new Shark[R + 1][C + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			Shark tmp = new Shark(r, c, s, d, z);
			sharks.add(tmp);
			map[r][c] = tmp;
		}

		sum = 0;
		for (int i = 1; i <= C; i++) {
			fish(i);
			moveShark();
			fight();
		}
		System.out.println(sum);
	}

	private static void moveShark() {
		for (int i = 0; i < sharks.size(); i++) {
			Shark s = sharks.get(i);
			int x = s.r;
			int y = s.c;
			for (int j = 1; j <= s.s; j++) {
				x += dx[s.d];
				y += dy[s.d];
				if (x <= 0 || x >= R + 1 || y <= 0 || y >= C + 1) {
					if (s.d % 2 == 0) {
						s.d--;
					} else {
						s.d++;
					}
					x += dx[s.d];
					y += dy[s.d];
					j--;
				}
			}
			map[s.r][s.c] = null;
			s.r = x;
			s.c = y;
		}
	}

	private static void fight() {
		for (int i = sharks.size() - 1; i >= 0; i--) {
			Shark s = sharks.get(i);

			if (map[s.r][s.c] != null) {
				Shark o = map[s.r][s.c];
				if (o.z > s.z) {
					map[s.r][s.c] = o;
					sharks.remove(s);
				} else {
					map[s.r][s.c] = s;
					sharks.remove(o);
				}
			} else {
				map[s.r][s.c] = s;
			}

		}

	}

	private static void fish(int col) {
		for (int i = 1; i <= R; i++) {
			Shark s = map[i][col];
			if (s != null) {
				sum += s.z;
				map[s.r][s.c] = null;
				sharks.remove(s);
				break;
			}
		}

	}

	static class Shark {
		int r, c, s, d, z; // (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}

}
