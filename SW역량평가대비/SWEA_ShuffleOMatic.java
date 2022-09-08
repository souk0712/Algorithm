
public class SWEA_ShuffleOMatic {

	private static int N;
	private static int min;
//	void DFS(셔플횟수, 현재 카드 배열) {
//		if 셔플횟수> 5 return
//		if 셔플횟수>= 최소 셔플 횟수 return
//		if 카드가 정렬 상태라면 최소 횟수 갱신 후 return
//		
//		1. 카드를 L, R 묶음으로 쪼개기
//		2. 모든 x값에 대해 셔플!
//			DFS(횟수 +1, 셔플 후 카드 배열)
//	}

	public static void main(String[] args) {

	}

	private static void DFS(int cnt, int[] cards) {
		if (cnt > 5)
			return;
		if (cnt >= min)
			return;

		// 1. 오름차순, 내림차순인지 검사
		if (isSorted(cards)) {
			min = Math.min(min, cnt);
			return;
		}

		// 2. 셔플을 위해 카드 나누기
		int[] left = new int[N / 2];
		int[] right = new int[N / 2];

		for (int i = 0; i < N / 2; i++) {
			left[i] = cards[i];
		}
		for (int i = N / 2; i < N; i++) {
			right[i - N / 2] = cards[i];
		}

		// 3. 카드 셔플
		for (int x = 1; x < N; x++) {
			int[] next = x < N / 2 ? shuffle(x, left, right) : shuffle(x - N / 2, right, left);
			DFS(cnt + 1, next);
		}

	}

	private static boolean isSorted(int[] cards) {
		boolean isUp = true;
		boolean isDown = true;
		for (int i = 0; i < N; i++) {
			if (cards[i] != i + 1)
				isUp = false;
			if (cards[i] != N - i)
				isDown = false;

			if (!isUp && !isDown)
				return false;
		}
		return true;
	}

	private static int[] shuffle(int x, int[] left, int[] right) {
		int[] next = new int[N];
		int idx = 0;
		int leftIdx = 0;
		int rightIdx = 0;

		while (leftIdx < N / 2 - x) {
			next[idx++] = left[leftIdx++];
		}

		int order = 0;
		while (leftIdx < N / 2 && rightIdx < N / 2) {
			next[idx++] = order % 2 == 0 ? right[rightIdx++] : left[leftIdx++];
			order++;
		}

		while (rightIdx < N / 2) {
			next[idx++] = right[rightIdx++];
		}
		return next;
	}

}
