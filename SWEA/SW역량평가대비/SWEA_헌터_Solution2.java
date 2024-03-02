import java.util.ArrayList;

public class SWEA_헌터_Solution2 {

//	void DFS(방문한 개수, 현재까지의 시간 합, 현재 위치 R, 현재 위치 C) {
//		if 현재까지의 거리 >= 최소거리 return
//		if 모든 고객, 몬스터르르 다 방문했다면 최소 시간 갱신 후 return
//		
//		1. 아직 방문하지 않은 몬스터를 DFS(개수 + 1, 늘어난 시간, 몬스터 R, 몬스터 C)
//		2. 아직 방문하지 않은 고객을 DFS(개수 + 1, 늘어난 시간, 고객 R, 고객 C)
//	}
	static class Node{
		int r;
		int c;
		int n;		// 고객, 몬스터 번호
		
		public Node(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
		
	}
	static int N;
	static ArrayList<Node> monsters;
	static ArrayList<Node> customers;
	static boolean[] visitedMonsters;
	static boolean[] visitedCustomers;
	static int min;
	
	
	public static void main(String[] args) {
		
	}

	private static void DFS(int cnt, int distance, int r, int c) {
		if(distance>=min)return;
		if(cnt==monsters.size()*2) {
			min = Math.min(min, distance);
		}
		// 1. 몬스터 잡기
		for (Node monster : monsters) {
			if(visitedMonsters[monster.n])continue;
			int d = getDistance(monster.r,monster.c,r,c);
			visitedMonsters[monster.n] = true;
			DFS(cnt+1,distance +d, monster.r,monster.c);
			visitedMonsters[monster.n] = false;
		}
		// 2. 고객 방문
		for(Node customer:customers) {
			int n = Math.abs(customer.n);
			if(visitedCustomers[n]||!visitedMonsters[n])continue;
			
			int d = getDistance(customer.r, customer.c, r, c);
			visitedCustomers[n] = true;
			DFS(cnt+1, distance+d, customer.r, customer.c);
			visitedCustomers[n] = false;
		}
	}
	private static int getDistance(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}

}
