import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ18870_좌표압축 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			pq.add(input[i]);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int index = 0;
		while (!pq.isEmpty()) {
			int key = pq.poll();
			if (!map.containsKey(key))
				map.put(key, index++);
		}
		for (int i = 0; i < N; i++) {
			int value = map.get(input[i]);
			sb.append(value).append(" ");
		}
		System.out.println(sb);

	}

}
