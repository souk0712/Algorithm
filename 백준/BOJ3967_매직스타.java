import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3967_매직스타 {

	private static boolean[] visited;
	private static int[] numbers;
	private static int[][] sumArea = { { 1, 3, 6, 8 }, { 2, 3, 4, 5 }, { 1, 4, 7, 11 }, { 8, 9, 10, 11 },
			{ 2, 6, 9, 12 }, { 5, 7, 10, 12 } };
	private static StringBuilder sb;
	private static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][9];
		visited = new boolean[13];
		numbers = new int[13];
		sb = new StringBuilder();
		for (int i = 0, index = 1; i < 5; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < input.length; j++) {
				int temp = input[j];
				map[i][j] = input[j];
				if (temp == 'x') {
					index++;
				} else if (temp != '.') {
					numbers[index++] = temp - 'A' + 1;
					visited[temp - 'A' + 1] = true;
				}
			}
		}

		fillNumber(1);
		makePrint();
		System.out.println(sb);

	}

	private static void makePrint() {
		int k = 1;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != '.') {
					map[i][j] = (char) (numbers[k++] + 'A' - 1);
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
	}

	private static boolean fillNumber(int num) {
		while (num < 13 && numbers[num] != 0)
			num++;
		if (num >= 13) {
			for (int i = 0; i < sumArea.length; i++) {
				int sum = 0;
				for (int j = 0; j < sumArea[i].length; j++) {
					sum += numbers[sumArea[i][j]];
				}
				if (sum != 26) {
					return false;
				}
			}
			return true;
		}

		for (int i = 1; i < 13; i++) {
			if (!visited[i]) {
				visited[i] = true;
				numbers[num] = i;
				if (fillNumber(num + 1)) {
					return true;
				}
				visited[i] = false;
				numbers[num] = 0;
			}
		}
		return false;
	}
}
