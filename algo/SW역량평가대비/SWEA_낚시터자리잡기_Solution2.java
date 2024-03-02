
public class SWEA_낚시터자리잡기_Solution2 {

	// 간단로직
//	void DFS(게이트 개수, 현재까지의 거리 합) {
//		if(현재까지의 거리>=최소거리)reutrn
//		if 3개의 게이트를 다 배치했다면 최소 거리 갱신 후 return
//				
//		1. 순열뽑기
//		2. 낚기군 배치
//		3. DFS(게이트 + 1, 배치 후 늘어난 거리)
//	}

	static class Gate {
		int pos;
		int fisher;

		public Gate(int pos, int fisher) {
			super();
			this.pos = pos;
			this.fisher = fisher;
		}
	}

	static int N; // 낚시터의 수 N
	static Gate[] gates; // 게이트 정보 저장
	static int min, fisherCnt; // min : 최소 이동 거리 (정답)
	static boolean[] selected; // 순열 selected 배열
	static int[] map; // 낚시터

	public static void main(String[] args) {

	}

	private static void DFS(int cnt, int sum) {
		if (sum >= min)
			return;
		if (cnt == 3) {
			min = Math.min(min, sum);
			return;
		}
		for (int i = 1; i <= 3; i++) {
			if (selected[i])
				continue;
			// 1. 게이트 선택
			selected[i] = true;
			// 2. 낚시꾼 배치
			DFS(cnt + 1, sum + inFishers(i, gates[i].fisher, true));
			outFishers(i);

			if (gates[i].fisher % 2 == 0) {
				DFS(cnt + 1, sum + inFishers(i, gates[i].fisher, false));
				outFishers(i);
			}

			// 3. 선택 해제
			selected[i] = false;
		}
	}

	// 배치했던 낚시꾼을 원래 상태로 되돌림
	private static void outFishers(int idx) {
		int cnt = 0;
		for (int j = 1; j <= N; j++) {
			if (map[j] == idx) {
				map[j] = 0;
				cnt++;
			}
			if (cnt == gates[idx].fisher)
				return;
		}

	}

	// 낚시꾼 배치 함수, flag = true이면 왼쪽 -> 오른쪽 순서로, false이면 오른쪽 -> 왼쪽 순서로 배치함
	private static int inFishers(int idx, int fishers, boolean flag) {
		int distance = 0;
		fisherCnt = 0; // 현재까지 배치한 낚시꾼의 수
		int sum = 0;

		while (fisherCnt < fishers) {
			sum += flag ? left(idx, distance) : right(idx, distance);
			if (fisherCnt == fishers)
				break;
			sum += flag ? right(idx, distance) : left(idx, distance);
			distance++;
		}
		return sum;
	}

	private static int left(int idx, int distance) {
		int left = gates[idx].pos - distance;
		if (left > 0 && map[left] == 0) {
			map[left] = idx;
			fisherCnt++;
			return distance + 1; // +1은 거리가 1부터 시작하기 때문
		}
		return 0;
	}

	private static int right(int idx, int distance) {
		int right = gates[idx].pos + distance;
		if (right > 0 && map[right] == 0) {
			map[right] = idx;
			fisherCnt++;
			return distance + 1; // +1은 거리가 1부터 시작하기 때문
		}
		return 0;
	}
}
