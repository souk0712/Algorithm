import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.naming.CommunicationException;

public class BOJ16235_나무재테크 {

	private static int[][] feed;
	private static int[][] map;

	private static int N;
	private static int M;
	private static int K;
	private static ArrayList<Tree> trees;
	private static Queue<Tree> dead;
	private static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		feed = new int[N + 1][N + 1];
		map = new int[N + 1][N + 1];
		trees = new ArrayList<>();
		dead = new LinkedList<>();
		// 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				feed[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, z));
		}

		// 나이적은순
		Collections.sort(trees, (t1, t2) -> t1.age - t2.age);

		// 처리
		for (int k = 0; k < K; k++) {
			spring();
			summer();
			fall();
			winter();
		}

		// 출력
		int count = 0;
		for (int i = 0; i < trees.size(); i++) {
			if (!trees.get(i).dead) {
				count++;
			}
		}
		System.out.println(count);

	}

	private static void winter() {
		// 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가. 각 칸에 추가되는 양분의 양은 A[r][c]
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] += feed[i][j];
			}
		}
	}

	private static void fall() {
		// 가을에는 나무가 번식한다. 번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
		ArrayList<Tree> newTrees = new ArrayList<>();

		for (int i = 0; i < trees.size(); i++) {
			Tree t = trees.get(i);
			if (!t.dead && t.age % 5 == 0) {
				for (int k = 0; k < 8; k++) {
					int x = t.x + dx[k];
					int y = t.y + dy[k];
					if (x <= 0 || y <= 0 || x > N || y > N)
						continue;
					newTrees.add(new Tree(x, y, 1));
				}
			}
		}
		for (Tree t : trees) {
			if (!t.dead) {
				newTrees.add(t);
			}
		}
		trees = newTrees;
	}

	private static void summer() {
		// 봄에 죽은 나무가 양분으로 변하게 된다. 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는
		// 버린다.
		while (!dead.isEmpty()) {
			Tree t = dead.poll();
			map[t.x][t.y] += t.age / 2;
		}

	}

	private static void spring() {
		// 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다. 각각의 나무는 나무가 있는 1×1 크기의 칸에 있는 양분만 먹을 수 있다.
		// 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다. 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수
		// 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
		for (int i = 0; i < trees.size(); i++) {
			Tree t = trees.get(i);
			if (!t.dead) {
				int x = t.x;
				int y = t.y;
				int age = t.age;
				if (map[x][y] >= age) {
					map[x][y] -= age;
					t.age++;
				} else {
					t.dead = true;
					dead.offer(t);

//					trees.remove(i);

				}
			}
		}
	}

	static class Tree {
		int x, y, age;
		boolean dead;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Tree [x=" + x + ", y=" + y + ", age=" + age + ", dead=" + dead + "]";
		}

	}
}
