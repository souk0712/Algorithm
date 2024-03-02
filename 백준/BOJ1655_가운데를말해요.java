import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1655_가운데를말해요 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		});
		for (int i = 1; i <= N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (maxPQ.size() <= minPQ.size()) {
				maxPQ.offer(tmp);
			} else {
				minPQ.offer(tmp);
			}
			if (!maxPQ.isEmpty() && !minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
				int temp1 = maxPQ.poll();
				int temp2 = minPQ.poll();
				maxPQ.offer(temp2);
				minPQ.offer(temp1);
			}
			sb.append(maxPQ.peek() + "\n");

		}
		System.out.println(sb);
	}

}
