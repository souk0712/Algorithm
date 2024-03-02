import java.util.ArrayList;
import java.util.Collections;

public class SWEA_헌터_Solution1 {

	static ArrayList<Node> infos;
	static boolean[]chk;	// 탐색 여부
	private static int placeNum;
	private static int ans;

	public static void main(String[] args) {
		Collections.sort(infos); // 방문할 장소 정보에 따라 정렬
	}

	// 방문해야 할 위치를 저장하고 일을 수 있는 기능
	static class Node implements Comparable<Node> {
		int r, c, type;
		// r 행의 위치
		// c 열의 위치
		// type 행선지 정보
		// (ex -1 : 1번 고객)
		// (ex 1 : 1번 몬스터)

		public Node(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

		@Override
		public int compareTo(Node o) {
			return Math.abs(this.type) == Math.abs(o.type) ? Integer.compare(this.type, o.type)
					: Integer.compare(Math.abs(this.type), Math.abs(o.type));
		}
	}

	static void dfs(int dep, int sumDis, int hr, int hc) {
		if(dep==placeNum) {
			ans = Math.min(ans, sumDis);
			return;
		}
	}
	// 맨하탄 거리
	static int calcDis(Node des, int hr, int hc) {
		return Math.abs(hr - des.r) + Math.abs(hc - des.c);
	}
}
